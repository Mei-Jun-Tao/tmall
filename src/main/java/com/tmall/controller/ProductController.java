package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@RequestMapping
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_product_add")
    public String add(Product p){
        p.setCreateDate(new Date());
        productService.add(p);

        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id){
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_update")
    public String update(Product p){
        p.setCreateDate(new Date());
        productService.update(p);

        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String edit(int id, Model model){
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCid());

        model.addAttribute("c", c);
        model.addAttribute("p", p);

        return "admin/editProduct";
    }

    @RequestMapping("admin_product_list")
    public String list(int cid, Model model, Page page){
        PageHelper.offsetPage(page.getStrat(), page.getCount());
        List<Product> products = productService.list(cid);
        int total = (int) new PageInfo<Product>(products).getTotal();
        Category category = categoryService.get(cid);
        page.setTotal(total);
        page.setParam("&cid=" + category.getId());

        //设置图片
        productService.getProduct(products);

        model.addAttribute("ps", products);
        model.addAttribute("page", page);
        model.addAttribute("c", category);

        return "admin/listProduct";
    }
}
