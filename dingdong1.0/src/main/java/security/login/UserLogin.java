package security.login;

import jdk.nashorn.internal.parser.Token;
import security.annotation.UserLoginToken;
import security.entity.User;
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

    @PatchMapping("/login")
    @ResponseBody
    public Object login(@RequestBody User user){
        User userForBase = userService.findByUsername(user.getUsername());
        if(userForBase == null){
            Map<String,String> result = new HashMap<>();
            result.put("success","False");
            result.put("msg","登录失败，用户不存在");
            return result;
        }
        else{
            String token = tokenService.getToken(userForBase);
            Map<String, String> result = new HashMap<>();
            result.put("success","True");
            result.put("msg",token);
            return result;
        }
    }
}
