package com.yelv.yelv_blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Article;
import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.service.ArticleService;
import com.yelv.yelv_blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 标签控制器
 */
@Controller
public class TagIndexController {

    @Autowired
    TagService tagService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/tags/{tagId}")
    public String tags(@PathVariable Integer tagId, @RequestParam(required = false,defaultValue = "1",value = "pageNum")int pageNum,
                        Model model){
        PageHelper.startPage(pageNum, 4);  //开启分页
        List<Tag> tags = tagService.getArticleTag();
        //-1从导航点过来的
        if (tagId == -1){
            tagId = tags.get(0).getTagId();
        }
        List<Article> articles = articleService.getByTagId(tagId);

        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTagId", tagId);

        return "/home/tags";
    }
}
