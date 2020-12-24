package mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String user_name;
    String password;
    char user_type;     //"U" or "M"
    @OneToMany
    List<Order> history_order;
}
