package mysqlData.repository;

import mysqlData.bean.Gym;
import org.springframework.data.repository.CrudRepository;

public interface GymRepository extends CrudRepository<Gym, Integer> {

}
