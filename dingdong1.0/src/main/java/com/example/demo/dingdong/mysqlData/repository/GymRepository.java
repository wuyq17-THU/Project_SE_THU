package com.example.demo.dingdong.mysqlData.repository;

import com.example.demo.dingdong.mysqlData.bean.Gym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends CrudRepository<Gym, Integer> {
    Gym findBySportKind(String sportKind);

}
