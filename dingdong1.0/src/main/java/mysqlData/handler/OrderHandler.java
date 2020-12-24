package mysqlData.handler;

import mysqlData.bean.Order;
import mysqlData.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderHandler {
    @Resource
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }
}
