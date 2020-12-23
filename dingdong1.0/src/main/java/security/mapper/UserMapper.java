package security.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import security.entity.User;


public class UserMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User findByUsername(String username){
        User user = new User();
        String sql = "SELECT Password FROM Login Msg where Name = " + '"' + username + '"';
        user.setPassword(jdbcTemplate.queryForObject(sql, String.class));
        user.setUsername(username);
        sql = "SELECT User_id FROM Login Msg where Name = " + '"' + username + '"';
        user.setID(jdbcTemplate.queryForObject(sql,Integer.class));
        return user;
    }
}
