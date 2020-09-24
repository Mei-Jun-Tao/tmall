package com.tmall.service;

import com.tmall.mapper.PropertyMapper;
import com.tmall.pojo.Property;
import com.tmall.pojo.PropertyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    
    @Autowired
    PropertyMapper propertyMapper;

    public Integer add(Property property){
        return propertyMapper.insert(property);
    }

    public void delete(int id){
        propertyMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Property property){
        return propertyMapper.updateByPrimaryKey(property);
    }
    public Property get(int id){
        return propertyMapper.selectByPrimaryKey(id);
    }

    public List<Property> list(int cid){
        PropertyExample example = new PropertyExample();
        example.setOrderByClause("id ASC");
        example.createCriteria().andCidEqualTo(cid);

        return propertyMapper.selectByExample(example);
    }
}
