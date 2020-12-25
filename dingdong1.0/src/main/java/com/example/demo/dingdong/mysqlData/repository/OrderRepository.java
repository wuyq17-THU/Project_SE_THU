package com.example.demo.dingdong.mysqlData.repository;

import com.example.demo.dingdong.mysqlData.bean.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<UserOrder, Integer> {
}
