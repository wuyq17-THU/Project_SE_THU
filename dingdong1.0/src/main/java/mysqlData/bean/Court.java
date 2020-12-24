package mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int gym_id;
    int[][] time_status;    // 0:rentable, 1:rented, -1:not rentable
}
