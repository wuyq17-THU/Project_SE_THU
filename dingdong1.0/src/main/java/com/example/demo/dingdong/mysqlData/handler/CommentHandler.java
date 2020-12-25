package com.example.demo.dingdong.mysqlData.handler;

import com.example.demo.dingdong.mysqlData.bean.Comment;
import com.example.demo.dingdong.mysqlData.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentHandler {
    @Resource
    private CommentRepository commentRepository;

    public void save(Comment comment){
        commentRepository.save(comment);
    }
}
