package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * フォームから送られるコメント情報
 */
public class CommentForm {

    private Integer articleId;

    /**
     * 名前
     */
    @NotBlank(message = "名前を入力してください")
    @Size(max = 50, message = "名前は50字以内で入力してください")
    private String name;

    /**
     * コメント
     */
    @NotBlank(message = "内容を入力して下さい")
    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    @Override
    public String toString() {
        return "CommentForm{" +
                "articleId=" + articleId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
