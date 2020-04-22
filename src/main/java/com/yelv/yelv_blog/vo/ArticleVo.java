package com.yelv.yelv_blog.vo;

import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo extends Article {

    private Integer categoryId;

    private Integer tagId;

    private User user;

    private List<Tag> tagList;

    private List<Category> categoryList;

}
