package com.codemcd.springbootvuejsweb.service;

import com.codemcd.springbootvuejsweb.domain.Article;
import com.codemcd.springbootvuejsweb.domain.ArticleRepository;
import com.codemcd.springbootvuejsweb.service.dto.ArticleRequestDto;
import com.codemcd.springbootvuejsweb.service.dto.ArticleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public ArticleResponseDto create(ArticleRequestDto articleRequestDto) {
        Article article = new Article(articleRequestDto.getAuthor(),
                articleRequestDto.getTitle(),
                articleRequestDto.getContents());

        Article savedArticle = articleRepository.save(article);

        return new ArticleResponseDto(savedArticle.getId(),
                savedArticle.getAuthor(),
                savedArticle.getTitle(),
                savedArticle.getContents());
    }
}
