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
            gymRepository.findById(gymId).get().getComments().add(comment);
        }
    }
}