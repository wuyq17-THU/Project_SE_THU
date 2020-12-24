package mysqlData.bean;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;
    @ManyToOne
    @JoinColumn(name = "court_id")
    Court court;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    boolean cancelable;
    boolean finished;
    LocalDate order_date;
    int start_time;
}
