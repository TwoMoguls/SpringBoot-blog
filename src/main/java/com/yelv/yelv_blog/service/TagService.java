package com.yelv.yelv_blog.service;

import com.yelv.yelv_blog.entity.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Integer tagId);

    Tag getTagByName(String tagName);

    List<Tag> getAllTags();

    int updateTag(Tag tag);

    void deleteTag(Integer tagId);
}
