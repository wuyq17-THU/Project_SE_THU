package userApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.bean.Comment;
import mysqlData.bean.Gym;
import mysqlData.bean.User;
import mysqlData.handler.CommentHandler;
import mysqlData.handler.GymHandler;
import mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddCourtCommentController {
    @Autowired
    GymHandler gymHandler;

    @Autowired
    UserHandler userHandler;

    @Autowired
    CommentHandler commentHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CourtCommentResponse{
        boolean success;
        String msg;
    }

    private static class CourtCommentRequest{
        int gymId;
        String comment;
    }

    @PostMapping("/api/user/rent/comment")
    @ResponseBody
    public CourtCommentResponse AddCourtComment(@RequestBody CourtCommentRequest courtCommentRequest, @RequestAttribute("user") String username){
        Gym gym = gymHandler.findById(courtCommentRequest.gymId);
        if(gym == null){
            return new CourtCommentResponse(false, "gym does not exist");
        }
        Comment comment = new Comment(0,gym,userHandler.getUserByName(username),courtCommentRequest.comment);
        commentHandler.save(comment);
        gymHandler.addCommentByGymId(courtCommentRequest.gymId, comment);
        return new CourtCommentResponse(true, null);
    }
}
