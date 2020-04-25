package com.yelv.yelv_blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.entity.User;
import com.yelv.yelv_blog.service.ArticleService;
import com.yelv.yelv_blog.service.CategoryService;
import com.yelv.yelv_blog.service.TagService;
import com.yelv.yelv_blog.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 博客文章管理控制器
 */

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    /**
     * 文章页
     * @return
     */
    @GetMapping("/article")
    public String article() {
        return "admin/article";
    }

    /**
     * 文章新增
     * @param model
     * @return
     */
    @GetMapping("/addArticle")
    public String addArticle(Model model){
        List<Category> categories = categoryService.getAllCategory();
        List<Tag> tags = tagService.getAllTags();
        model.addAttribute("categories",categories);
        model.addAttribute("tags",tags);
        return "admin/addArticle";
    }

    /**
     * 文章列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/getArticle")
    public Messages getCategory(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize") Integer pageSize){
        System.out.println(pageNum);
        PageHelper.startPage(pageNum,8);
        List<Article> articles = articleService.getAllArticle();
        System.out.println(articles);
        System.out.println(articles);
        PageInfo pageInfo = new PageInfo(articles,pageSize);
        return Messages.success().add("pageInfo",pageInfo);

    }

    @ResponseBody
    @PostMapping("/article")
    public Messages addCategory(Article article, HttpSession session){
        System.out.println(article);
        // session中存在User在登录时设置了
        User user = (User) session.getAttribute("user");
        article.setArticleUserId(user.getUserId());
        articleService.saveArticle(article);
        return Messages.success().add("article",article);

    }
}

