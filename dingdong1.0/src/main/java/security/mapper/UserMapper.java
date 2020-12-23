package security.mapper;

import mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import security.entity.LoginUser;


public class UserMapper {
    @Autowired
    private UserHandler userHandler;
    public LoginUser findByUsername(String username){
        LoginUser loginUser = new LoginUser();
        loginUser.setPassword(userHandler.getPwByName(username));
        loginUser.setUsername(username);
        return loginUser;
    }
}
