package security.login;

import security.annotation.UserLoginToken;
import security.entity.LoginUser;
import security.service.TokenService;
import security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserLogin {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PatchMapping("/api/user/login")
    @ResponseBody
    public Object login(@RequestBody LoginUser loginUser){
        LoginUser loginUserForBase = userService.findByUsername(loginUser.getUsername());
        if(loginUserForBase == null){
            Map<String,String> result = new HashMap<>();
            result.put("success","False");
            result.put("msg","登录失败，用户不存在");
            return result;
        }
        else{
            String token = tokenService.getToken(loginUserForBase);
            Map<String, String> result = new HashMap<>();
            result.put("success","True");
            result.put("msg",token);
            return result;
        }
    }
    
}
