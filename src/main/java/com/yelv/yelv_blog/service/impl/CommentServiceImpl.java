package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.Comment;
import com.yelv.yelv_blog.mapper.CommentMapper;
import com.yelv.yelv_blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByArticleId(Integer articleId) {
        return commentMapper.getCommentByArticleId(articleId);
    }

    @Override
    public int saveComment(Comment comment) {
        return commentMapper.saveComment(comment);
    }
}
