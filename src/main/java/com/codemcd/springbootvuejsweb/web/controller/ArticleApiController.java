package com.codemcd.springbootvuejsweb.web.controller;

import com.codemcd.springbootvuejsweb.service.ArticleService;
import com.codemcd.springbootvuejsweb.service.dto.ArticleRequestDto;
import com.codemcd.springbootvuejsweb.service.dto.ArticleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ArticleApiController {
    private ArticleService articleService;

    public ArticleApiController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/api/articles")
    public ResponseEntity create(@RequestBody ArticleRequestDto articleRequestDto) {
        ArticleResponseDto createdArticle = articleService.create(articleRequestDto);
        return ResponseEntity
                .created(URI.create("/articles/" + createdArticle.getId()))
                .body(createdArticle);
    }
}
