package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.ArticleAndTag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {

    // 推荐
    @Select("select article_id, article_title, article_commend from article order by article_update_time desc")
    List<Article> getAllCommendArticle();

    // 保存文章ID和标签ID
    @Insert("insert into article_tag_ref (tag_id, article_id) values (#{tagId},#{articleId})")
    int saveArticleAndTag(ArticleAndTag articleAndTag);

    @Delete("delete from Article where article_id = #{articleId}")
    int deleteArticle(@Param("articleId") Integer articleId);

    @Select("select article_id, article_title from article where article_title = #{articleTitle}")
    Article getArticleByTitle(@Param("articleTitle") String articleTitle);

    List<Article> getAllArticle();

    int saveArticle(Article article);

    int updateArticle(Article article);

    @Select("SELECT COUNT(*) FROM article")
    int countArticle();  //查询博客条数

    @Select("SELECT article_id, article_title, article_commend FROM article ORDER BY article_update_time DESC")
    List<Article> getAllRecommendArticle();

    Article getDetailedArticle(@Param("articleId") Integer articleId);  //前端展示博客

    List<Article> searchAllArticle(Article article);  //后台根据标题、分类、推荐搜索博客

    Article getArticle(Integer articleId);  //后台展示博客

    List<Article> getByCategoryId(@Param("categoryId") Integer categoryId);  //根据类型id获取博客

    List<Article> getByTagId(@Param("tagId") Integer tagId);  //根据标签id获取博客

    List<Article> getIndexArticle();  //主页博客展示

    List<Article> getSearchArticle(String query);  //全局搜索博客

    Map<String,List<Article>> archiveArticle();  //归档博客
}
