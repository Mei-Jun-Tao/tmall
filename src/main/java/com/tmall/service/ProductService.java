package com.tmall.service;

import com.tmall.mapper.ProductMapper;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductExample;
import com.tmall.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductImageService productImageService;

    public Integer add(Product product){
        return productMapper.insert(product);
    }

    public void delete(int id){
        productMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Product product){
        return productMapper.updateByPrimaryKey(product);
    }
    public Product get(int id){
        return productMapper.selectByPrimaryKey(id);
    }

    public List<Product> list(int cid){
        ProductExample example = new ProductExample();
        example.setOrderByClause("id ASC");
        example.createCriteria().andCidEqualTo(cid);

        return productMapper.selectByExample(example);
    }

    //给产品设置图片
    public void getProduct(List<Product> products){
        for(Product product : products){
            getProduct(product);
        }
    }
    public void getProduct(Product p){
        //根据产品获取单个图片集合
        List<ProductImage> pi = productImageService.list(p.getId(), ProductImageService.single);
        if(pi.isEmpty())
            return;
        p.setProductImage(pi.get(0));
    }

}
