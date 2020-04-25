package com.yelv.yelv_blog.service;

import com.yelv.yelv_blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByArticleId(Integer articleId);

    int saveComment(Comment comment);
}
