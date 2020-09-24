package com.tmall.service;

import com.tmall.mapper.CategoryMapper;
import com.tmall.pojo.Category;
import com.tmall.pojo.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public Integer add(Category c){
        return categoryMapper.insert(c);
    }

    public void delete(int id){
        categoryMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Category c){
        return categoryMapper.updateByPrimaryKey(c);
    }

    public Category get(int id){
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<Category> list(){
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id ASC");

        return categoryMapper.selectByExample(example);
    }
}
