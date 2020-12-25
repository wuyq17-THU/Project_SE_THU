package com.example.demo.dingdong.mysqlData.repository;

import com.example.demo.dingdong.mysqlData.bean.Court;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends CrudRepository<Court, Integer> {
}
