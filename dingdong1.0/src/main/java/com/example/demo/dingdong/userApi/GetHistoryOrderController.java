package com.example.demo.dingdong.userApi;

import com.example.demo.dingdong.mysqlData.bean.User;
import com.example.demo.dingdong.security.annotation.UserLoginToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.dingdong.mysqlData.bean.UserOrder;
import com.example.demo.dingdong.mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetHistoryOrderController {
    @Autowired
    UserHandler userHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class singleOrderResponse {
        String gymKind;
        int courtId;
        String userName;
        int timeNum;
        String localdate;
        boolean cancelable;
        boolean finished;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HistoryOrderResponse {
        boolean success;
        List<singleOrderResponse> userOrders;
    }

    @UserLoginToken
    @GetMapping("/api/user/rent/history")
    @ResponseBody
    public HistoryOrderResponse GetHistoryOrder(@RequestAttribute("user") String username) {
        List<UserOrder> userOrders = userHandler.getHistoryOrderByUsername(username);
        List<singleOrderResponse> userOrdersResponse = new ArrayList<>();
        for (UserOrder userOrder : userOrders) {
            userOrdersResponse.add(new singleOrderResponse(userOrder.getGym().getSportKind(), userOrder.getCourt().getId(), userOrder.getUser().getUsername(), userOrder.getStartTime(), userOrder.getOrderDate().toString(), userOrder.isCancelable(), userOrder.isFinished()));
        }
        return new HistoryOrderResponse(true, userOrdersResponse);
    }
}
