package com.example.demo.dingdong.userApi;

import com.example.demo.dingdong.security.annotation.UserLoginToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.dingdong.mysqlData.bean.Comment;
import com.example.demo.dingdong.mysqlData.handler.GymHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class  GetCourtCommentController {
    @Autowired
    GymHandler gymHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class singleCommentResponse{
        String username;
        String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class CourtCommentResponse{
        List<singleCommentResponse> comments;
    }

    @Data
    private static class GymIdRequest{
        int gymId;
    }

    @UserLoginToken
    @PostMapping("/api/user/gym/getcomments")
    @ResponseBody
    public CourtCommentResponse GetCourtComment(@RequestBody GymIdRequest gymIdRequest){
        List<Comment> comments = gymHandler.getCommentsByGymId(gymIdRequest.gymId);
        List<singleCommentResponse> responseComments = new ArrayList<>();
        for(Comment comment: comments){
            responseComments.add(new singleCommentResponse(comment.getUser().getUsername(),comment.getContent()));
        }
        return new CourtCommentResponse(responseComments);
    }

}
