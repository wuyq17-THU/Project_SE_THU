//网球场订单
//订单由id，place（场地），date（星期），time（时间段），user（客户）组成
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class tennisticket {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@RequestMapping(value="/tennisticket_add", method=RequestMethod.GET)
	//订了Addtype馆，addplace号场地，Adddata日期，Addtime时间段的是Adduser
	public void tennisticket_add(int Add_place,int Add_date,int Add_time,String Add_user) {
		String sql = "INSERT INTO tennisticket (palce,date,time,user) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,Add_place,Add_date,Add_time,Add_user);		
	}
	@RequestMapping(value="/tennisticket_getfromUser", method=RequestMethod.GET)
	//根据用户的名字查询他的订单信息
	//TODO需要返回一个订单类
	public 订单类 tennisticket_getfromUser(String GetUser)  {
		String sql = "SELECT id FROM tennisticket where user=";
		sql = sql+'"'+GetUser+'"';
		int id = jdbcTemplate.queryForObject(sql,Integer.class);

		sql = "SELECT place FROM tennisticket where user=";
		sql = sql+'"'+GetUser+'"';
		int place = jdbcTemplate.queryForObject(sql,Integer.class);
		
		sql = "SELECT date FROM tennisticket where user=";
		sql = sql+'"'+GetUser+'"';
		int date = jdbcTemplate.queryForObject(sql,Integer.class);
		
		sql = "SELECT time FROM tennisticket where user=";
		sql = sql+'"'+GetUser+'"';
		int time = jdbcTemplate.queryForObject(sql,Integer.class);
		
	}
	@RequestMapping(value="/tennisticket_getAll", method=RequestMethod.GET)
	public List<订单类> tennisticket_getAll(int type)  {
		
		String sql = "SELECT user FROM tennisticket";
		List<String>users = jdbcTemplate.queryForList(sql,string.class);
		
		//TODO对list中的所有对象用tennisticket_getfromUser即可查询一个订单类的List
		
	}
}