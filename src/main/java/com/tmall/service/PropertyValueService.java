package com.tmall.service;

import com.tmall.mapper.PropertyValueMapper;
import com.tmall.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyValueService {

    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Autowired
    PropertyService propertyService;

    public Integer add(PropertyValue pv){
        return propertyValueMapper.insert(pv);
    }

    public Integer update(PropertyValue pv){
        return propertyValueMapper.updateByPrimaryKey(pv);
    }
    public PropertyValue get(int id){
        return propertyValueMapper.selectByPrimaryKey(id);
    }

    public List<PropertyValue> list(int pid){
        PropertyValueExample example = new PropertyValueExample();
        example.setOrderByClause("id ASC");
        example.createCriteria().andPidEqualTo(pid);

        return propertyValueMapper.selectByExample(example);
    }

    //为这些属性值设置对应的属性
    public List<PropertyValue> getPropertyValue(Category c, Product p){
        List<Property> propertys = propertyService.list(c.getId());
        //添加属性值
        List<PropertyValue> pvs = new ArrayList<>();

        for(Property property : propertys){
            PropertyValue pv = new PropertyValue();
            pv.setPid(p.getId());
            pv.setPtid(property.getId());
            pv.setProperty(property);
            pvs.add(pv);
        }

        return pvs;
    }
}
