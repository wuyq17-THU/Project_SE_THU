package mysqlData.handler;

import mysqlData.bean.Comment;
import mysqlData.bean.Gym;
import mysqlData.repository.GymRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GymHandler {
    @Resource
    private GymRepository gymRepository;
    public Gym findById(int id){
        return gymRepository.findById(id).get();
    }

    public List<Comment> getCommentsByGymId(int gymId){
        return findById(gymId).getComments();
    }

    public void addCommentByGymId(int gymId, Comment comment){
        gymRepository.findById(gymId).get().getComments().add(comment);
        return;
    }
}
