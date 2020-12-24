package userApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetSelfInfoController {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class SelfInfoResponse{
        String userName;
        char userType;
    }

    @Autowired
    UserHandler userHandler;

    @GetMapping("/api/user/info")
    @ResponseBody
    public SelfInfoResponse GetSelfInfo(@RequestAttribute("user") String username){
        return new SelfInfoResponse(username, userHandler.getUserByName(username).getUser_type());
    }
}
