package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.ArticleAndTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {
    Article getArticle(Integer articleId);  //后台展示博客

    Article getDetailedArticle(Integer articleId);  //前端展示博客

    List<Article> getAllArticle();

    List<Article> getByTypeId(Integer categoryId);  //根据类型id获取博客

    List<Article> getByTagId(Integer tagId);  //根据标签id获取博客

    List<Article> getIndexArticle();  //主页博客展示

    @Select("select article_id, article_title, article_commend from article order by article_update_time desc")
    List<Article> getAllCommendArticle();  //推荐博客展示

    List<Article> getSearchArticle(String query);  //全局搜索博客

    Map<String,List<Article>> archiveArticle();  //归档博客

    int countArticle();  //查询博客条数

    int saveArticle(Article article);

    @Insert("insert into article_tag_ref (tag_id, article_id) values (#{tagId},#{articleId})")
    int saveBlogAndTag(ArticleAndTag articleAndTag);

    int updateArticle(Article article);

    @Delete("delete from Article where article_id = #{articleId}")
    int deleteArticle(Integer articleId);

    List<Article> searchAllArticle(Article article);  //后台根据标题、分类、推荐搜索博客
}
