package com.codemcd.springbootvuejsweb.service;

import com.codemcd.springbootvuejsweb.domain.Article;
import com.codemcd.springbootvuejsweb.domain.ArticleRepository;
import com.codemcd.springbootvuejsweb.service.dto.ArticleRequestDto;
import com.codemcd.springbootvuejsweb.service.dto.ArticleResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글을 레포지토리에 정상적으로 저장한다.")
    void create_article() {
        ArticleRequestDto articleRequestDto = new ArticleRequestDto("park",
                "Hello",
                "Nice to meet you.");

        given(articleRepository.save(any())).willReturn(new Article(articleRequestDto.getAuthor(),
                articleRequestDto.getTitle(), articleRequestDto.getContents()));

        ArticleResponseDto articleResponseDto = articleService.create(articleRequestDto);

        assertThat(articleResponseDto).isNotNull();
    }
}
