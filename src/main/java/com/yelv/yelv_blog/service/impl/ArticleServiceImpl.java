package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.mapper.ArticleMapper;
import com.yelv.yelv_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章业务层
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int countArticle() {
        return articleMapper.countArticle();
    }

    @Override
    public Article getArticleByTitle(String articleTitle) {
        return articleMapper.getArticleByTitle(articleTitle);
    }

    @Override
    public int saveArticle(Article article) {
        return articleMapper.saveArticle(article);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    @Override
    public List<Article> getAllRecommendArticle() {
        return articleMapper.getAllRecommendArticle();
    }

    @Override
    public Article getDetailedArticle(Integer articleId) {
        return articleMapper.getDetailedArticle(articleId);
    }

    @Override
    public List<Article> getByCategoryId(Integer categoryId) {
        return articleMapper.getByCategoryId(categoryId);
    }

    @Override
    public List<Article> getIndexArticle() {
        return articleMapper.getIndexArticle();
    }

    @Override
    public List<Article> getByTagId(Integer tagId) {
        return articleMapper.getByTagId(tagId);
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
    public Article getArticle(Integer id) {
        return null;
    }


}
