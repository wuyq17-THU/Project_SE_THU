//有关帐户的账号密码验证

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class User_Login {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@RequestMapping(value="/Add_UserMsg", method=RequestMethod.GET)
	//加入一个用户的账号名和密码，形式为两个字符串
	public void Add_UserMsg(String User_Name,String User_Password) {
		String sql = "INSERT INTO Login_Msg (Name,Password) VALUES (?,?)";
		jdbcTemplate.update(sql,User_Name,User_Password);
	}
	@RequestMapping(value="/Check_UserMsg", method=RequestMethod.GET)
	//判定一对账号名和密码是否匹配，输入两个字符串，返回一个 
	public boolean Check_UserMsg(String User_Name,String User_Password)  {
		String sql = "SELECT Password FROM Login_Msg where Name = " + '"'+User_Name+'"';
		String Password = jdbcTemplate.queryForObject(sql,String.class);
		return Password.equals(User_Password);
	}
	//以下为测试代码
	/*@RequestMapping(value="/User_Login", method=RequestMethod.GET)
	public int Add_UserMsg() {
		String sql = "INSERT INTO Login_Msg (Name,Password) VALUES (?,?)";
		jdbcTemplate.update(sql,"test1","123456");
		return 1;
	}
	public boolean Check_UserMsg() {
		String User_Name = "test1";
		String User_Password = "12356";
		String sql = "SELECT Password FROM Login_Msg where Name = " + '"'+User_Name+'"';
		String Password = jdbcTemplate.queryForObject(sql,String.class);
		return Password.equals(User_Password);
		//return true;
	}
	*/
}