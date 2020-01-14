package com.codemcd.springbootvuejsweb.dto;

public class ArticleResponseDto {
    private Long id;
    private String author;
    private String title;
    private String contents;

    public ArticleResponseDto(Long id, String author, String title, String contents) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
