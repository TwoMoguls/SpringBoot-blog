package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.mapper.TagMapper;
import com.yelv.yelv_blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签逻辑层
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public Tag getTag(Integer tagId) {
        return tagMapper.getTag(tagId);
    }

    @Override
    public Tag getTagByName(String tagName) {
        return tagMapper.getTagByName(tagName);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        tagMapper.deleteTag(tagId);
    }
}
