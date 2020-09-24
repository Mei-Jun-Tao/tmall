package com.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;
import com.tmall.util.Image;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RequestMapping
@Controller
public class CategroyController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_add")
    public String add(Category category, Image image, HttpSession session){
        categoryService.add(category);
        try {
            //创建文件
            File imgFload = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imgFload, category.getId() + ".jpg");
            //判断父文件是否存在
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            image.getImage().transferTo(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect: admin_category_list";
    }

    @RequestMapping("admin_category_delete")
    public String delete(Category c, HttpSession session){
        categoryService.delete(c.getId());
        File imgFload = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imgFload, c.getId() + ".jpg");
        file.delete();

        return "redirect: admin_category_list";
    }

    @RequestMapping("admin_category_update")
    public String update(Category c, Image image, HttpSession session){
        categoryService.update(c);
        try {
            //创建文件
            File imgFload = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imgFload, c.getId() + ".jpg");

            image.getImage().transferTo(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String edit(Category c, Model model){
        Category category = categoryService.get(c.getId());
        model.addAttribute("c", category);
        return "admin/editCategory";
    }

    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        //创建分页
        PageHelper.offsetPage(page.getStrat(), page.getCount());
        List<Category> cs = categoryService.list();
        //设置总数居
        int total = (int) new PageInfo<Category>(cs).getTotal();
        page.setTotal(total);

        model.addAttribute("cs", cs);
        model.addAttribute("page", page);

        return "admin/listCategory";
    }

}
