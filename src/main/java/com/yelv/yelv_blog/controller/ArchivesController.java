package com.yelv.yelv_blog.controller;

import com.yelv.yelv_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchivesController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/archives")
    public String archives(Model model) {

        return "/home/archives";
    }
}
