package mysqlData.handler;

import mysqlData.bean.Comment;
import mysqlData.repository.CommentRepository;
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
