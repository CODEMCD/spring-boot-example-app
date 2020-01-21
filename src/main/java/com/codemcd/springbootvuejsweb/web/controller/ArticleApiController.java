package com.codemcd.springbootvuejsweb.web.controller;

import com.codemcd.springbootvuejsweb.service.ArticleService;
import com.codemcd.springbootvuejsweb.service.dto.ArticleRequestDto;
import com.codemcd.springbootvuejsweb.service.dto.ArticleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/api/articles")
    public ResponseEntity showAll() {
        List<ArticleResponseDto> articles = articleService.showAll();

        return ResponseEntity.ok(articles);
    }

    @PutMapping("/api/articles/{articleId}")
    public ResponseEntity update(@PathVariable("articleId") Long articleId,
                                 @RequestBody ArticleRequestDto articleUpdateRequestDto) {
        ArticleResponseDto updatedArticle = articleService.update(articleId, articleUpdateRequestDto);

        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/api/articles/{articleId}")
    public ResponseEntity delete(@PathVariable("articleId") Long articleId) {
        articleService.delete(articleId);

        return ResponseEntity.ok().build();
    }
}
