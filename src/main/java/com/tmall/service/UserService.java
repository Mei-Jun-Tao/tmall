package com.tmall.service;

import com.tmall.mapper.UserMapper;
import com.tmall.pojo.User;
import com.tmall.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Integer add(User u){
        return userMapper.insert(u);
    }

    public Integer update(User u){
        return userMapper.updateByPrimaryKey(u);
    }
    public User get(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> list(){
        UserExample example = new UserExample();
        example.setOrderByClause("id ASC");

        return userMapper.selectByExample(example);
    }

}
