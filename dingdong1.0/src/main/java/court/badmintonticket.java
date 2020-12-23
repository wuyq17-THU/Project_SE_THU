//羽毛球场订单
//订单由id，place（场地），date（星期），time（时间段），user（客户）组成
package court;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import court.entities.BadmintonTicket;

@RestController
public class badmintonticket {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(value="/badmintonticket_add", method=RequestMethod.GET)
    //订了Addtype馆，addplace号场地，Adddata日期，Addtime时间段的是Adduser
    public void badmintonticket_add(int Add_place,int Add_date,int Add_time,String Add_user) {
        String sql = "INSERT INTO badmintonticket (palce,date,time,user) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,Add_place,Add_date,Add_time,Add_user);
    }
    @RequestMapping(value="/badmintonticket_getfromUser", method=RequestMethod.GET)
    //根据用户的名字查询他的订单信息
    //TODO需要返回一个订单类
    public BadmintonTicket badmintonticket_getfromUser(String GetUser)  {
        String sql = "SELECT id FROM badmintonticket where user=";
        sql = sql+'"'+GetUser+'"';
        BadmintonTicket ticket = new BadmintonTicket();
        int id = jdbcTemplate.queryForObject(sql,Integer.class);
        ticket.setId(id);

        sql = "SELECT place FROM badmintonticket where user=";
        sql = sql+'"'+GetUser+'"';
        int place = jdbcTemplate.queryForObject(sql,Integer.class);
        ticket.setPlace(place);

        sql = "SELECT date FROM badmintonticket where user=";
        sql = sql+'"'+GetUser+'"';
        int date = jdbcTemplate.queryForObject(sql,Integer.class);
        ticket.setDate(date);

        sql = "SELECT time FROM badmintonticket where user=";
        sql = sql+'"'+GetUser+'"';
        int time = jdbcTemplate.queryForObject(sql,Integer.class);
        ticket.setTime(time);
        return ticket;
    }
    @RequestMapping(value="/badmintonticket_getAll", method=RequestMethod.GET)
    public List<BadmintonTicket> badmintonticket_getAll(int type)  {

        String sql = "SELECT user FROM badmintonticket";
        List<String> users = jdbcTemplate.queryForList(sql,String.class);

        List<BadmintonTicket> tickets = new ArrayList();
        for(String user:users){
            tickets.add(badmintonticket_getfromUser(user));
        }
        return tickets;
    }
}