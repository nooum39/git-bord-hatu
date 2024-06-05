package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * フォームから送られる記事情報
 */
public class ArticleForm {
    /**
     * 投稿者名
     */
    @NotBlank(message = "名前を入力してください")
    @Size(max = 50, message = "名前は50字以内で入力してください")
    private String name;

    /**
     * 投稿内容
     */
    @NotBlank(message = "内容を入力して下さい")
    private String content;

    @Override
    public String toString() {
        return "ArticleForm{" +
                "name='" + name + '\'' +
                ", comment='" + content + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
