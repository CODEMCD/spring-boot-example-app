package com.codemcd.springbootexampleapp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest {

    @Test
    @DisplayName("게시글 제목과 본문을 수정한다.")
    void update() {
        Article source = new Article("park", "hi", "hihi");
        Article target = new Article("park", "bye", "byebye");

        source.update(target);

        assertThat(source.getTitle()).isEqualTo("bye");
        assertThat(source.getContents()).isEqualTo("byebye");
    }
}
