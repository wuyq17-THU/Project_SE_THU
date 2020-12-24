package mysqlData.repository;

import mysqlData.bean.Gym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends CrudRepository<Gym, Integer> {
}
