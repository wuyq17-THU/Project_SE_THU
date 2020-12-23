package mysqlData.repository;

import mysqlData.bean.Court;
import org.springframework.data.repository.CrudRepository;

public interface CourtRepository extends CrudRepository<Court, Integer> {
}
