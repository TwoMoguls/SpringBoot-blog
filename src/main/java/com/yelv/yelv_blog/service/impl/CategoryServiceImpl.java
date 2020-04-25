package com.yelv.yelv_blog.service.impl;

import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.mapper.CategoryMapper;
import com.yelv.yelv_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类业务层
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    @Override
    public int saveCategory(Category category) {
        return categoryMapper.saveCategory(category);
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return categoryMapper.getCategory(categoryId);
    }


    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryMapper.getCategoryByName(categoryName);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Transactional
    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Transactional
    @Override
    public void deleteCategory(Integer categoryId) {
        categoryMapper.deleteCategory(categoryId);
    }

    @Override
    public List<Category> getArticleCategory() {
        return categoryMapper.getArticleCategory();
    }
}
