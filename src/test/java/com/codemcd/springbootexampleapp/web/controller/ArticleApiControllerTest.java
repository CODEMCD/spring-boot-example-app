package com.codemcd.springbootexampleapp.web.controller;

import com.codemcd.springbootexampleapp.service.dto.ArticleRequestDto;
import com.codemcd.springbootexampleapp.service.dto.ArticleResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ArticleApiControllerTest {
    private static final String LOCATION = "Location";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("게시글을 정상적으로 생성, 조회, 수정, 삭제한다.")
    void CRUD() {
        String author = "park";
        String title = "안녕하세요.";
        String contents = "반갑습니다.";
        ArticleRequestDto articleRequestDto = new ArticleRequestDto(author, title, contents);

        // 게시글 생성
        ArticleResponseDto articleResponseDto = webTestClient.post().uri("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(articleRequestDto), ArticleRequestDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectHeader().valueMatches(LOCATION, "\\/articles\\/\\d")
                .expectBody(ArticleResponseDto.class)
                .returnResult()
                .getResponseBody()
        ;

        assert articleResponseDto != null;
        assertThat(articleResponseDto.getId()).isEqualTo(1L);
        assertThat(articleResponseDto.getAuthor()).isEqualTo(author);
        assertThat(articleResponseDto.getTitle()).isEqualTo(title);
        assertThat(articleResponseDto.getContents()).isEqualTo(contents);

        // 게시글 조회(전체 게시글 조회)
        webTestClient.get().uri("/api/articles")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$..id").isEqualTo(1)
                .jsonPath("$..author").isEqualTo(author)
                .jsonPath("$..title").isEqualTo(title)
                .jsonPath("$..contents").isEqualTo(contents)
                ;

        // 게시글 수정
        ArticleRequestDto updateArticleRequest = new ArticleRequestDto(author, "hi", "bye");
        ArticleResponseDto updatedArticleResponse = webTestClient.put().uri("/api/articles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updateArticleRequest), ArticleRequestDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ArticleResponseDto.class)
                .returnResult()
                .getResponseBody()
                ;

        assert updatedArticleResponse != null;
        assertThat(updatedArticleResponse.getId()).isEqualTo(1L);
        assertThat(updatedArticleResponse.getAuthor()).isEqualTo(author);
        assertThat(updatedArticleResponse.getTitle()).isEqualTo("hi");
        assertThat(updatedArticleResponse.getContents()).isEqualTo("bye");

        // 게시글 삭제
        webTestClient.delete().uri("/api/articles/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                ;
    }
}
