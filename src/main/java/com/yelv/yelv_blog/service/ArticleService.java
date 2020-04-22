package com.yelv.yelv_blog.service;

import com.yelv.yelv_blog.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Article getArticle(Integer id);  //后台展示博客

    Article getDetailedArticle(Integer id);  //前端展示博客

    List<Article> getAllArticle();

    List<Article> getByTypeId(Integer categoryId);  //根据类型id获取博客

    List<Article> getByTagId(Integer tagId);  //根据标签id获取博客

    List<Article> getIndexArticle();  //主页博客展示

    List<Article> getAllRecommendArticle();  //推荐博客展示

    List<Article> getSearchArticle(String query);  //全局搜索博客

    Map<String,List<Article>> archiveArticle();  //归档博客

    int countArticle();  //查询博客条数

    int saveArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);

    List<Article> searchAllArticle(Article article);  //后台根据标题、分类、推荐搜索博客
}
