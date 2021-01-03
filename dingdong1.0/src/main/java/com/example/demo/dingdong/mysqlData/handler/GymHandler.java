package com.example.demo.dingdong.mysqlData.handler;

import com.example.demo.dingdong.mysqlData.bean.Comment;
import com.example.demo.dingdong.mysqlData.bean.Gym;
import com.example.demo.dingdong.mysqlData.repository.GymRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GymHandler {
    @Resource
    private GymRepository gymRepository;

    public Gym findById(int id) {
        if (gymRepository.findById(id).isPresent()) {
            return gymRepository.findById(id).get();
        }
        return null;
    }

    public List<Comment> getCommentsByGymId(int gymId) {
        return findById(gymId).getComments();
    }

    public void addCommentByGymId(int gymId, Comment comment) {
        if (gymRepository.findById(gymId).isPresent()) {
            Gym gym = gymRepository.findById(gymId).get();
            gym.addComment(comment);
            gymRepository.save(gym);
        }
    }

    public Gym findGymBySportKind(String sportKind){
        return gymRepository.findBySportKind(sportKind);
    }
}
