package com.example.demo.dingdong.security.service;

import com.example.demo.dingdong.security.entity.LoginUser;
import com.example.demo.dingdong.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public LoginUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
