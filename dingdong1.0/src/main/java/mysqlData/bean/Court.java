package mysqlData.bean;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int gym_id;
    boolean is_ordered;
    boolean is_forbidden;
    List<Order> curr_orders;
    List<Order> reservations;
}
