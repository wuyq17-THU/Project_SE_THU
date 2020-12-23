package security.service;

import security.entity.LoginUser;
import security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public LoginUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
