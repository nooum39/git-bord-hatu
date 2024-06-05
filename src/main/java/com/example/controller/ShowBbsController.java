package com.example.controller;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 記事を取得するコントローラ.
 *
 * @author reon.hatsuda
 */
@Controller
@RequestMapping("/bbs")
public class ShowBbsController {


    @Autowired
    private ArticleRepositoryM articleRepository;

    /**
     * 掲示板を表示する.
     *
     * @param aform 記事投稿のリクエストフォーム
     * @param model
     * @return 掲示板のhtml
     */
    @GetMapping("")
    public String index(ArticleForm aform, Model model) {
//        List<Article> articles = articleRepository.findAllWithComments();
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "bbs";
    }

}
