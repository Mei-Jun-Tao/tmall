package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.pojo.User;
import com.tmall.service.UserService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(User user, Model model, Page page){
        PageHelper.offsetPage(page.getStrat(), page.getCount());
        List<User> users = userService.list();
        int total = (int) new PageInfo<User>(users).getTotal();
        page.setTotal(total);

        model.addAttribute("page", page);
        model.addAttribute("us", users);

        return "admin/listUser";
    }
}
