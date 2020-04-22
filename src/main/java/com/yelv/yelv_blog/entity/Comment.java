package com.yelv.yelv_blog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客评论
 */
@Data
public class Comment {

    private Integer commentId;
    private String stat;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Article blog;
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;

}
