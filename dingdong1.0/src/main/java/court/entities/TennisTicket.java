package court.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//网球场订单
//订单由id，place（场地），date（星期），time（时间段），user（客户）组成
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TennisTicket {
    int id;
    int place;
    int date;
    int time;
    int user;
}
