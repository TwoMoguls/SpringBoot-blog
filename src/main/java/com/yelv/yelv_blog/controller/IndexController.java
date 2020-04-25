package com.yelv.yelv_blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.service.ArticleService;
import com.yelv.yelv_blog.service.CategoryService;
import com.yelv.yelv_blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(@RequestParam(required = false,defaultValue = "1",value = "pageNum")int pageNum, Model model){
        PageHelper.startPage(pageNum, 4);
        List<Article> articles = articleService.getIndexArticle();
        List<Category> categories = categoryService.getArticleCategory();
        List<Tag> tags = tagService.getArticleTag();
        List<Article> commend = articleService.getAllRecommendArticle();

        //得到分页结果对象
        PageInfo pageInfo = new PageInfo(articles);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", tags);
        model.addAttribute("categories", categories);
        model.addAttribute("commend", commend);
        return "index";
    }

    @GetMapping("/article/{articleId}")
    public String toArticle(@PathVariable Integer articleId, Model model){
        Article article = articleService.getDetailedArticle(articleId);
        model.addAttribute("article", article);
        return "/home/article";
    }
}
