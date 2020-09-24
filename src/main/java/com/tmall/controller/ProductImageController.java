package com.tmall.controller;

import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;
import com.tmall.service.CategoryService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import com.tmall.util.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RequestMapping
@Controller
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_productImage_add")
    public String add(ProductImage pi, HttpSession session, Image image){
        productImageService.add(pi);

        Product p = productService.get(pi.getPid());

        try {
            //上传图片的类型
            String type = pi.getType();

            //创建文件对象
            File fileFload = new File(session.getServletContext().getRealPath("img"), "/" + type);
            File file = new File(fileFload, pi.getId() + ".jpg");
            //判断父文件是否存在
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();

            image.getImage().transferTo(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:admin_productImage_list?pid=" + p.getId();
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(int id, HttpSession session){
        ProductImage pi = productImageService.get(id);
        String type = pi.getType();
        Product p = productService.get(pi.getPid());
        File fileFload = new File(session.getServletContext().getRealPath("img"), "/" + type);
        File file = new File(fileFload, pi.getId() + ".jpg");
        file.delete();

        productImageService.delete(id);

        return "redirect:admin_productImage_list?pid=" + p.getId();
    }

    @RequestMapping("admin_productImage_list")
    public String list(Model model, int pid){
        //单个图片集合
        List<ProductImage> single = productImageService.list(pid, ProductImageService.single);
        List<ProductImage> detall = productImageService.list(pid, ProductImageService.detall);
        Product p = productService.get(pid);
        Category c = categoryService.get(p.getCid());

        model.addAttribute("single", single);
        model.addAttribute("detall", detall);
        model.addAttribute("p", p);
        model.addAttribute("c", c);

        return "admin/listProductImage";
    }
}
