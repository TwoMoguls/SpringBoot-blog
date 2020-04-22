package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 文章业务层
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public Article getArticle(Integer id) {
        return null;
    }

    @Override
    public Article getDetailedArticle(Integer id) {
        return null;
    }

    @Override
    public List<Article> getAllArticle() {
        return null;
    }

    @Override
    public List<Article> getByTypeId(Integer categoryId) {
        return null;
    }

    @Override
    public List<Article> getByTagId(Integer tagId) {
        return null;
    }

    @Override
    public List<Article> getIndexArticle() {
        return null;
    }

    @Override
    public List<Article> getAllRecommendArticle() {
        return null;
    }

    @Override
    public List<Article> getSearchArticle(String query) {
        return null;
    }

    @Override
    public Map<String, List<Article>> archiveArticle() {
        return null;
    }

    @Override
    public int countArticle() {
        return 0;
    }

    @Override
    public int saveArticle(Article article) {
        return 0;
    }

    @Override
    public int updateArticle(Article article) {
        return 0;
    }

    @Override
    public int deleteArticle(Integer articleId) {
        return 0;
    }

    @Override
    public List<Article> searchAllArticle(Article article) {
        return null;
    }
}
