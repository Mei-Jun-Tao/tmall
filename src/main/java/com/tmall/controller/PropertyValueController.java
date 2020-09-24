package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.pojo.Property;
import com.tmall.pojo.PropertyValue;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyValueService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Controller
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_propertyValue_list")
    public String list(Model model, int pid, Page page){
        Product p = productService.get(pid);
        Category c = categoryService.get(p.getCid());
        PageHelper.offsetPage(page.getStrat(), page.getCount());
        List<PropertyValue> pvs = propertyValueService.getPropertyValue(c, p);
        int total = (int) new PageInfo<PropertyValue>(pvs).getTotal();
        page.setTotal(total);
        page.setParam("&pid=" + p.getId());

        model.addAttribute("page", page);
        model.addAttribute("pvs", pvs);
        model.addAttribute("p", p);
        model.addAttribute("c", c);

        return "admin/listPropertyValue";
    }

    @RequestMapping("admin_propertyValue_edit")
    public String edit(int id, Model model){
        PropertyValue pv = propertyValueService.get(id);

        model.addAttribute("pv", pv);

        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    public String update(PropertyValue pv){
        Product p = productService.get(pv.getPid());
        propertyValueService.update(pv);

        return "redirect:admin_propertyValue_list?pid=" + p.getId();
    }
}
