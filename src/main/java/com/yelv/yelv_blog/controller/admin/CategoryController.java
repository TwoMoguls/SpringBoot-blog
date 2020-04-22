package com.yelv.yelv_blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yelv.yelv_blog.entity.Category;
import com.yelv.yelv_blog.service.CategoryService;
import com.yelv.yelv_blog.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 分类控制器
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类页
     * @return
     */
    @GetMapping("/category")
    public String category(){
        return "admin/category";
    }

    /**
     * 获取分类及分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/getCategory")
    public Messages getCategory(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize") Integer pageSize){
        System.out.println(pageNum);
        PageHelper.startPage(pageNum,8);
        List<Category> categories = categoryService.getAllCategory();
        System.out.println(categories);
        PageInfo pageInfo = new PageInfo(categories,pageSize);
        return Messages.success().add("pageInfo",pageInfo);

    }

    /**
     * 添加分类信息
     * @param category
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/category")
    public String postCategory(Category category, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        Category category1 = categoryService.getCategoryByName(category.getCategoryName());
        if(category1 != null){
            bindingResult.rejectValue("name","nameError","不能添加重复的分类");
        }
       int integer = categoryService.saveCategory(category);
        if(integer != 0){
            redirectAttributes.addFlashAttribute("message","新增成功…………^ o ^");
        }else {
            redirectAttributes.addFlashAttribute("message","新增失败………… O _ O");
        }
        return "redirect:/admin/category";
    }
    /**
     * 更新分类信息
     * 注：功能还没完善
     */
    @ResponseBody
    @PutMapping("/getCategory/{categoryId}")
    public Messages updateCategory(Category category, HttpServletRequest httpServletRequest){
        System.out.println("请求体中的值："+httpServletRequest.getParameter("categoryName"));
        System.out.println("将要更新的员工数据："+category);
        categoryService.updateCategory(category);
        return Messages.success();
    }
    /**
     * 删除分类信息
     */
    @ResponseBody
    @DeleteMapping("/getCategory/{categoryId}")
    public Messages deleteCategory(@PathVariable("categoryId") Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return Messages.success();
    }
}
