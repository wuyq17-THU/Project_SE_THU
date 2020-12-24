package mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;
    int[][] time_status;    // 0:rentable, 1:rented, -1:not available
}
