package com.yelv.yelv_blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Tag;
import com.yelv.yelv_blog.service.TagService;
import com.yelv.yelv_blog.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 标签控制器
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 标签页
     * @return
     */
    @GetMapping("/tag")
    public String tag(){
        return "admin/tag";
    }

    /**
     * 获取标签及分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/getTags")
    public Messages getTags(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum,8);
        List<Tag> tags = tagService.getAllTags();
        PageInfo pageInfo = new PageInfo(tags,pageSize);
        return Messages.success().add("pageInfo",pageInfo);

    }

    /**
     * 新增标签
     * @param tag
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/tag")
    public String postCategory(Tag tag, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        Tag tag1 = tagService.getTagByName(tag.getTagName());
        if(tag1 != null){
            bindingResult.rejectValue("name","nameError","不能添加重复的分类");

        }
        int integer = tagService.saveTag(tag);
        if(integer != 0){
            redirectAttributes.addFlashAttribute("message","新增成功…………^ o ^");
        }else {
            redirectAttributes.addFlashAttribute("message","新增失败………… O _ O");
        }
        return "/admin/tag";
    }
    /**
     * 更新标签信息
     * 注：功能还没完善
     */
    @ResponseBody
    @PutMapping("/getTag/{tagId}")
    public Messages updateCategory(Tag tag, HttpServletRequest httpServletRequest){
        System.out.println("请求体中的值："+httpServletRequest.getParameter("tagName"));
        System.out.println("将要更新的员工数据："+tag);
        tagService.updateTag(tag);
        return Messages.success();
    }
    /**
     * 删除标签信息
     */
    @ResponseBody
    @DeleteMapping("/getTag/{tagId}")
    public Messages deleteCategory(@PathVariable("tagId") Integer tagId){
        tagService.deleteTag(tagId);
        return Messages.success();
    }
}
