package com.yelv.yelv_blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.service.ArticleService;
import com.yelv.yelv_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryIndexController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/categories/{categoryId}")
    public String category(@PathVariable Integer categoryId, @RequestParam(required = false,defaultValue = "1",value = "pageNum")int pageNum,
                           Model model){
        PageHelper.startPage(pageNum, 4);
        List<Category> categories = categoryService.getArticleCategory();
        System.out.println(categories);
        //-1从导航点过来的
        if (categoryId == -1){
            categoryId = categories.get(0).getCategoryId();
        }
        List<Article> articles = articleService.getByCategoryId(categoryId);
        System.out.println(articles);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("categories", categories);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeArticleId", categoryId);

        return "/home/category";
    }
}
