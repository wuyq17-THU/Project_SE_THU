package com.example.demo.dingdong.security.login;

import com.example.demo.dingdong.security.entity.LoginUser;
import com.example.demo.dingdong.security.service.TokenService;
import com.example.demo.dingdong.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.sun.activation.registries.LogSupport.log;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserLogin {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PatchMapping("/login")
    @ResponseBody
    public Object login(@RequestBody LoginUser loginUser) {
        LoginUser loginUserForBase = null;
        try {
            loginUserForBase = userService.findByUsername(loginUser.getUsername());
        }catch (Exception e){
            log("exception happened here");
        }
        if (loginUserForBase == null) {
            Map<String, String> result = new HashMap<>();
            result.put("success", "false");
            result.put("msg", "登录失败，用户不存在");
            return result;
        } else {
            String token = tokenService.getToken(loginUserForBase);
            Map<String, String> result = new HashMap<>();
            result.put("success", "True");
            result.put("msg", token);
            return result;
        }
    }

}
