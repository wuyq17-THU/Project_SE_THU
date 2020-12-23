package mysqlData.repository;

import mysqlData.bean.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Integer> {

}
