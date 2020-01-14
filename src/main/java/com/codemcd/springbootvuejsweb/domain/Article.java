package com.codemcd.springbootvuejsweb.domain;

import javax.persistence.*;

@Entity
@Table(name = "ARTICLES")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "TITLE", length = 200)
    private String title;

    @Lob
    @Column(name = "CONTENTS")
    private String contents;

    protected Article() {
    }

    public Article(String author, String title, String contents) {
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
