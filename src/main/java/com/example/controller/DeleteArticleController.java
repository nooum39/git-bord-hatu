package com.example.controller;


import com.example.repository.ArticleRepository;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * .記事を削除する.
 *
 * @author reon.hatsuda
 */
@Controller
@RequestMapping("/bbs")
public class DeleteArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    /**
     * 指定したidの記事を削除する.
     *
     * @param articleId 削除する記事のid
     * @return リダイレクト先
     */
    @PostMapping("/delete-article")
    public String deleteArticle(
            @RequestParam(name = "articleId", required = true) @PositiveOrZero Integer articleId
    ){
        articleRepository.deleteById(articleId);
        return "redirect:/bbs";
    }
}
