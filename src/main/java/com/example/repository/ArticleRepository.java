package com.example.repository;

import com.example.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * 記事関連のリポジトリです.
 *
 * @author haruka.yamaneki
 */

@Repository
public class ArticleRepository {
    private static final RowMapper<Article> ARTICLE_RESULT_SET_EXTRACTOR = (rs, i) -> {
        Article Article = new Article();
        Article.setId(rs.getInt("id"));
        Article.setName(rs.getString("name"));
        Article.setContent(rs.getString("content"));
        Article.setCommentList(new ArrayList<>());
        return Article;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;


    /**
     * 記事を全件表示するメソッド.
     *
     * @return 記事全件
     */
    public List<Article> findAll() {
        String sql = "SELECT id,name,content FROM articles ORDER BY id DESC";
        List<Article> articleList = template.query(sql, ARTICLE_RESULT_SET_EXTRACTOR);
        return articleList;
    }

    /**
     * 記事を追加するメソッド.
     *
     * @param article  記事　
     */
    public void insert(Article article) {
        String sql = "INSERT INTO articles (name,content) VALUES(:name,:content);";
        SqlParameterSource param = new BeanPropertySqlParameterSource(article);
        template.update(sql, param);
    }

    /**
     * 記事を削除するメソッド.
     *
     * @param id　記事
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM articles WHERE id=:id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        template.update(sql, param);
    }


}
