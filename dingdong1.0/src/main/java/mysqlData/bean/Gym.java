package mysqlData.bean;

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
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String sport_kind;
    List<Court> courts;
}
