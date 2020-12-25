package com.example.demo.dingdong.mysqlData.handler;

import com.example.demo.dingdong.mysqlData.bean.UserOrder;
import com.example.demo.dingdong.mysqlData.repository.OrderRepository;
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

    public void save(UserOrder userOrder) {
        orderRepository.save(userOrder);
    }

    //超过30天的订单删除，昨日的订单设finished为true，本周的订单设cancelable为false
    public void changeAndDeleteFinishedOrders() {
        Iterable<UserOrder> orders = orderRepository.findAll();
        Iterator<UserOrder> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            UserOrder userOrder = orderIterator.next();
            if (LocalDate.now().toEpochDay() - userOrder.getOrderDate().toEpochDay() > 30) {
                orderIterator.remove();
            } else if (LocalDate.now().minusDays(1).equals(userOrder.getOrderDate())) {
                userOrder.setFinished(true);
            } else if ( LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).plusDays(1).isAfter(userOrder.getOrderDate())){
                userOrder.setCancelable(false);
            }

        }
    }
}
