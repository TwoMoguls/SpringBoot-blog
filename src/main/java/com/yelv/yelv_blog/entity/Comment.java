package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 博客评论
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer commentId;

    private String commentAuthorAvatar;

    private String commentContent;

    private Date commentCreateTime;

    private String commentAuthorName;

    private Integer commentArticleId;

    private Article article;


}
