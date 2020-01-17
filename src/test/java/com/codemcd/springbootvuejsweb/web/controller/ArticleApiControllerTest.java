package com.codemcd.springbootvuejsweb.web.controller;

import com.codemcd.springbootvuejsweb.service.dto.ArticleRequestDto;
import com.codemcd.springbootvuejsweb.service.dto.ArticleResponseDto;
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
    @DisplayName("게시글을 정상적으로 생성한다.")
    void create_article() {
        String author = "park";
        String title = "안녕하세요.";
        String contents = "반갑습니다.";
        ArticleRequestDto articleRequestDto = new ArticleRequestDto(author, title, contents);

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
    }
}
