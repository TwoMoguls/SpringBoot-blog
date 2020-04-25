package com.yelv.yelv_blog.service;

import com.yelv.yelv_blog.entity.Article;

import java.util.List;

public interface ArticleService {

    int saveArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);

    int countArticle();

    Article getArticleByTitle(String articleTitle);

    Article getArticle(Integer id);  //后台展示博客

    Article getDetailedArticle(Integer id);  //前端展示博客

    List<Article> getAllArticle();

    List<Article> getByCategoryId(Integer categoryId);  //根据类型id获取文章

    List<Article> getByTagId(Integer tagId);  //根据标签id获取文章

    List<Article> getIndexArticle();

    List<Article> getAllRecommendArticle();  //推荐文章展示

}
