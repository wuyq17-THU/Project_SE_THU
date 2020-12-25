package com.example.demo.dingdong.mysqlData.handler;

import com.example.demo.dingdong.mysqlData.bean.UserOrder;
import com.example.demo.dingdong.mysqlData.bean.User;
import com.example.demo.dingdong.mysqlData.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserHandler {
    @Resource
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public String getPwByName(String user_name) {
        return userRepository.findByUsername(user_name).getPassword();
    }

    public User getUserByName(String user_name) {
        return userRepository.findByUsername(user_name);
    }

    public void addHistoryOrderByUsername(String username, UserOrder userOrder) {
        getUserByName(username).getHistoryUserOrder().add(userOrder);
    }

    public List<UserOrder> getHistoryOrderByUsername(String username) {
        return getUserByName(username).getHistoryUserOrder();
    }
}
