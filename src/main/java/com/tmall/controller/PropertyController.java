package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.pojo.Category;
import com.tmall.pojo.Property;
import com.tmall.service.CategoryService;
import com.tmall.service.PropertyService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Controller
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_property_add")
    public String add(Property p){
        propertyService.add(p);

        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id){
        Property p = propertyService.get(id);
        propertyService.delete(id);

        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_property_update")
    public String update(Property p){
        propertyService.update(p);

        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String edit(int id, Model model){
        Property p = propertyService.get(id);
        Category c = categoryService.get(p.getCid());
        model.addAttribute("c", c);
        model.addAttribute("p", p);

        return "admin/editProperty";
    }

    @RequestMapping("admin_property_list")
    public String list(Property p, Model model, Page page, int cid){
        PageHelper.offsetPage(page.getStrat(), page.getCount());
        List<Property> ps = propertyService.list(cid);
        int total = (int) new PageInfo<Property>(ps).getTotal();
        Category c = categoryService.get(cid);
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());

        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        model.addAttribute("c", c);

        return "admin/listProperty";
    }
}
