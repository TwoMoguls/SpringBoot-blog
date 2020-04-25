package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    List<Comment> getCommentByArticleId(Integer articleId);

    int saveComment(Comment comment);
}
