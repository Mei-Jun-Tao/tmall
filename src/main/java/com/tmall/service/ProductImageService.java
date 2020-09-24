package com.tmall.service;

import com.tmall.mapper.ProductImageMapper;
import com.tmall.pojo.Category;
import com.tmall.pojo.ProductImage;
import com.tmall.pojo.ProductImageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    ProductImageMapper productImageMapper;

    public static final String single = "single";
    public static final String detall = "detall";

    public Integer add(ProductImage productImage){
        return productImageMapper.insert(productImage);
    }

    public void delete(int id){
        productImageMapper.deleteByPrimaryKey(id);
    }

    public Integer update(ProductImage productImage){
        return productImageMapper.updateByPrimaryKey(productImage);
    }
    public ProductImage get(int id){
        return productImageMapper.selectByPrimaryKey(id);
    }

    public List<ProductImage> list(int pid, String type){
        ProductImageExample example = new ProductImageExample();
        example.setOrderByClause("id ASC");
        example.createCriteria()
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);

        return productImageMapper.selectByExample(example);
    }
}
