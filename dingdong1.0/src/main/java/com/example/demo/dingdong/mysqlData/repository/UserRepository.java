package com.example.demo.dingdong.mysqlData.repository;

import com.example.demo.dingdong.mysqlData.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String user_name);
}

