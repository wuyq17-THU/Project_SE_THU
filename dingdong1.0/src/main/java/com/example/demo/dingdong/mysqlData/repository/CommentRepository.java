package com.example.demo.dingdong.mysqlData.repository;

import com.example.demo.dingdong.mysqlData.bean.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
