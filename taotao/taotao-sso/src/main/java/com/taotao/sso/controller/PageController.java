package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 显示登录页和注册页
 */
@Controller
public class PageController {
    @RequestMapping("/user/page/register")
    public String showRegister() {
        return "register";
    }

    @RequestMapping("/user/page/login")
    public String showLogin(String redirect, Model model) {
        //把url参数传递到jsp
        model.addAttribute("redirect", redirect);
        return "login";
    }
}
