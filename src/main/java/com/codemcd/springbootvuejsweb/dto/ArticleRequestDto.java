package com.codemcd.springbootvuejsweb.dto;

public class ArticleRequestDto {
    private String author;
    private String title;
    private String contents;

    public ArticleRequestDto(String author, String title, String contents) {
        this.author = author;
        this.title = title;
        this.contents = contents;
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
