package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {
		
		String sql = "SELECT name FROM test where id = 1";
		// 通过jdbcTemplate查询数据库
		String mobile = jdbcTemplate.queryForObject(sql, String.class);		
        return "Hello "+ mobile ;
    }
	@RequestMapping(value="/change", method=RequestMethod.GET)
    public String change() {
		
		String sql = "update test set name=? where id=1";
		jdbcTemplate.update(sql, "yty");
		// 通过jdbcTemplate查询数据库
		sql = "SELECT name FROM test where id = 1";
		String mobile = jdbcTemplate.queryForObject(sql, String.class);		
        return "Hello "+ mobile ;
    }	
	/*@Override
    public User getUserById(Integer id) {
        List<User> list = jdbcTemplate.query("select * from tb_user where id = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
 
    @Override
    public List<User> getUserList() {
        List<User> list = jdbcTemplate.query("select * from tb_user", new Object[]{}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
 
 
    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into tb_user(username, age, ctm) values(?, ?, ?)",
                user.getUsername(),user.getAge(), new Date());
    }
 
    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE tb_user SET username = ? , age = ? WHERE id=?",
                user.getUsername(),user.getAge(), id);
    }
 
    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_user where id = ? ",id);
    }
*/
}