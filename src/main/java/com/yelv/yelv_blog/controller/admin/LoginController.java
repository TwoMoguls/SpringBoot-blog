package com.yelv.yelv_blog.controller.admin;

import com.yelv.yelv_blog.entity.User;
import com.yelv.yelv_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 后台登录控制器
 */

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 跳转登录夜
     * @return
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    /**
     * 验证密码
     * @param userName
     * @param userPass
     * @param session
     * @param attributes
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String userPass,
                        HttpSession session,
                        RedirectAttributes attributes){
        System.out.println(userName);
        User user = userService.checkUser(userName, userPass);
        if(user != null){
            user.setUserPass(null);
            session.setAttribute("user", user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/index")
    public String index(){
        return "/admin/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}