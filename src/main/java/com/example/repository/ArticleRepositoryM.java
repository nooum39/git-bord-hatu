package com.example.repository;

import com.example.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryM {

    public List<Article> findAll(){
        List<Article> articles = new ArrayList<>();
        Article a1 = new Article();
        a1.setId(1);
        a1.setContent("aaa");

        Article a2 = new Article();
        a1.setId(2);
        a1.setContent("bbb");

        Article a3 = new Article();
        a1.setId(3);
        a1.setContent("ccc");
        return articles;
    }
}
