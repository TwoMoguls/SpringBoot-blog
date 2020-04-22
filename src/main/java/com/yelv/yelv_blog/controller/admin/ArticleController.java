package com.yelv.yelv_blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客文章管理控制器
 */

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @GetMapping("/article")
    public String article() {
        return "admin/article";
    }
}

