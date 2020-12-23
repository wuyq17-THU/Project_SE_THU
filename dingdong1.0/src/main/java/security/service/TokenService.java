package security.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import security.entity.LoginUser;
import org.springframework.stereotype.Service;


@Service("TokenService")
public class TokenService {
    public String getToken(LoginUser loginUser){
        String token ="";
        token = JWT.create().withAudience(loginUser.getUsername()).sign(Algorithm.HMAC256(loginUser.getPassword()));
        return token;
    }
}
