package com.example.controller;


import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 記事の投稿を受け付けるコントローラ.
 *
 * @author reon.hatsuda
 */
@Controller
@RequestMapping("/bbs")
public class InsertArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 記事投稿を受け付ける.
     *
     * @param aform  記事投稿のリクエストフォーム
     * @param articleResult 結果
     * @param model  リクエストスコープ
     * @return 表示へリダイレクト
     */
    @PostMapping("/insert-article")
    public String insertArticle(
            @Validated ArticleForm aform,
            BindingResult articleResult,
            Model model
    ) {
        if (articleResult.hasErrors()) {
            model.addAttribute("articles", articleRepository.findAll());
            model.addAttribute("commentForm", new CommentForm());
            return "bbs";
        }

        Article article = new Article();
        BeanUtils.copyProperties(aform, article);
        articleRepository.insert(article);
        return "redirect:/bbs";
    }
}
