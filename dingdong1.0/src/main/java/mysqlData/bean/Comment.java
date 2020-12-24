package mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    Gym gym;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    String content;
}
