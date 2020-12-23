//网球馆，网球馆用1表示，羽毛球馆用2表示
//场地用place（场地几），date（星期几），time（时间段几），status（什么状态，0可预定，1已预订，2暂不能用）
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class tennis {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@RequestMapping(value="/tennis_change", method=RequestMethod.GET)
	//修改场地Change_place在星期Change_date,时间段Change_time的状态为Change_aim
	public void tennis_change(int Change_place,int Change_date,int Change_time,int Change_aim) {
		String sql = "update tennis set aim=? where place=?,date=?,time=?";
		jdbcTemplate.update(sql, Change_aim,Change_place,Change_date,Change_time);
	}
	@RequestMapping(value="/tennis_check", method=RequestMethod.GET)
	//查询场地Check_place在星期Check_date,时间段Check_time的状态
	public int tennis_check(int Check_place,int Check_date,int Check_time)  {
		String sql = "SELECT aim FROM tennis where place=";
		String place  = "" + Check_place;
		sql = sql+place+','+"date=";
		String date  = "" + Check_date;
		sql = sql+date+','+"time=";
		String time  = "" + Check_time;
		sql = sql+time;
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
}
	