package com.yelv.yelv_blog;

import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.service.ArticleService;
import com.yelv.yelv_blog.service.CategoryService;
import com.yelv.yelv_blog.service.TagService;
import com.yelv.yelv_blog.utils.Messages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class YelvBlogApplicationTests {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @Autowired
    TagService tagService;
    @Test
    public void getAllCategoriesTest(){
        List<Category> categories = categoryService.getAllCategory();
        Messages lis = Messages.success().add("categories",categories);
        System.out.println(lis.getData());

    }

}
