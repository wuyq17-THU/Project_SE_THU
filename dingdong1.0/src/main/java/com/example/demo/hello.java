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
}
