package com.yelv.yelv_blog.service;

import com.yelv.yelv_blog.entity.Category;

import java.util.List;


public interface CategoryService {

    int saveCategory(Category category);

    Category getCategory(Integer categoryId);

    Category getCategoryByName(String categoryName);

    List<Category>  getAllCategory();

    int updateCategory(Category category);

    void deleteCategory(Integer categoryId);
}
