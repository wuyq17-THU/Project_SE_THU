package mysqlData.handler;

import mysqlData.bean.Order;
import mysqlData.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;

@Service
public class OrderHandler {
    @Resource
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    //超过30天的订单删除，昨日的订单设finished为true，本周的订单设cancelable为false
    public void changeAndDeleteFinishedOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if (LocalDate.now().toEpochDay() - order.getOrder_date().toEpochDay() > 30) {
                orderIterator.remove();
            } else if (LocalDate.now().minusDays(1).equals(order.getOrder_date())) {
                order.setFinished(true);
            } else if ( LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).plusDays(1).isAfter(order.getOrder_date())){
                order.setCancelable(false);
            }

        }
    }
}
