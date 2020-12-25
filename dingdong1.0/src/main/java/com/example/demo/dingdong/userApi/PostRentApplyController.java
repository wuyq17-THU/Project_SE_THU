package com.example.demo.dingdong.userApi;

import com.example.demo.dingdong.security.annotation.UserLoginToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.dingdong.mysqlData.bean.Court;
import com.example.demo.dingdong.mysqlData.bean.Gym;
import com.example.demo.dingdong.mysqlData.bean.UserOrder;
import com.example.demo.dingdong.mysqlData.handler.CourtHandler;
import com.example.demo.dingdong.mysqlData.handler.GymHandler;
import com.example.demo.dingdong.mysqlData.handler.OrderHandler;
import com.example.demo.dingdong.mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@RestController
public class PostRentApplyController {
    @Autowired
    GymHandler gymHandler;

    @Autowired
    OrderHandler orderHandler;

    @Autowired
    UserHandler userHandler;

    @Autowired
    CourtHandler courtHandler;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RentApplyResponse {
        boolean success;
        String msg;
    }

    private static class RentApplyRequest {
        int gymId;
        int courtId;
        int weekNum;
        int timeNum;
    }

    @UserLoginToken
    @PostMapping("/api/user/rent/apply")
    @ResponseBody
    public RentApplyResponse PostRentApply(@RequestBody RentApplyRequest rentApplyRequest, @RequestAttribute("user") String username) {

        // 判断传入参数是否合法
        Gym gym = gymHandler.findById(rentApplyRequest.gymId);
        if (gym == null) {
            return new RentApplyResponse(false, "gym does not exist");
        }
        Court court;
        try {
            court = gym.getCourts().get(rentApplyRequest.courtId);
        } catch (IndexOutOfBoundsException e) {
            return new RentApplyResponse(false, "court does not exist on this gym");
        }
        if ((rentApplyRequest.weekNum < 0 || rentApplyRequest.weekNum >= 7) || (rentApplyRequest.timeNum < 0 || rentApplyRequest.timeNum >= 14)) {//todo: 每天的时间未直接确定，数据可能需要更改
            return new RentApplyResponse(false, "rent time is illegal");
        }

        //计算日期，生成并保存订单
        LocalDate orderDate = LocalDate.now().plusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).plusDays(rentApplyRequest.weekNum);
        UserOrder userOrder = new UserOrder(0, gym, court, userHandler.getUserByName(username), true, false, orderDate, rentApplyRequest.timeNum);
        orderHandler.save(userOrder);

        //在用户中添加历史订单
        userHandler.addHistoryOrderByUsername(username, userOrder);

        //在场地中更改状态
        if (!courtHandler.changeCourtStatusToRented(court, rentApplyRequest.weekNum, rentApplyRequest.timeNum)) {
            return new RentApplyResponse(false, "court is rented of unavailable");
        }


        return new RentApplyResponse(true, null);
    }
}
