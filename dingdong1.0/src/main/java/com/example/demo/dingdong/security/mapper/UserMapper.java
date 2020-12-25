package com.example.demo.dingdong.security.mapper;

import com.example.demo.dingdong.mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dingdong.security.entity.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private UserHandler userHandler;
    public LoginUser findByUsername(String username){
        LoginUser loginUser = new LoginUser();
        loginUser.setPassword(userHandler.getPwByName(username));
        loginUser.setUsername(username);
        return loginUser;
    }
}
