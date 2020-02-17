package com.codemcd.springbootexampleapp.service;

import com.codemcd.springbootexampleapp.domain.Article;
import com.codemcd.springbootexampleapp.domain.ArticleRepository;
import com.codemcd.springbootexampleapp.service.dto.ArticleRequestDto;
import com.codemcd.springbootexampleapp.service.dto.ArticleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<ArticleResponseDto> showAll() {
        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(article -> new ArticleResponseDto(article.getId(), article.getAuthor(),
                        article.getTitle(), article.getContents()))
                .collect(Collectors.toList())
                ;
    }

    @Transactional
    public ArticleResponseDto update(Long articleId, ArticleRequestDto articleUpdateRequestDto) {
        Article sourceArticle = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));
        Article targetArticle = new Article(articleUpdateRequestDto.getAuthor(),
                articleUpdateRequestDto.getTitle(), articleUpdateRequestDto.getContents());

        sourceArticle.update(targetArticle);

        return new ArticleResponseDto(sourceArticle.getId(),
                sourceArticle.getAuthor(),
                sourceArticle.getTitle(),
                sourceArticle.getContents());
    }

    @Transactional
    public void delete(Long articleId) {
        Article deleteArticle = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));

        articleRepository.delete(deleteArticle);
    }
}
