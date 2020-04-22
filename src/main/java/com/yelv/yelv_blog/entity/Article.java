package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 博客实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Integer articleId;

    private Integer articleUserId;

    private String articleContent;

    private String articleTitle;

    private Integer articleViewCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    private String articleSummary;

    private  boolean article_commend;

    private String articleImage;

}
