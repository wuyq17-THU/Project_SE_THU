package userApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.bean.Comment;
import mysqlData.handler.GymHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetCourtCommentController {
    @Autowired
    GymHandler gymHandler;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class CourtCommentResponse{
        List<Comment> comments;
    }

    private static class GymIdRequest{
        int gymId;
    }

    @PostMapping("/api/user/gym/getcomments")
    @ResponseBody
    public CourtCommentResponse GetCourtComment(@RequestBody GymIdRequest gymIdRequest){
        return new CourtCommentResponse(gymHandler.getCommentsByGymId(gymIdRequest.gymId));
    }

}
