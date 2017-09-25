package com.macro.ssm.controller;

import com.macro.ssm.po.User;
import com.macro.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhenghong on 2017/9/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public String findUserById(Model model, @PathVariable Integer id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/")
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
