package com.example.demo.dingdong.managerApi;

import com.example.demo.dingdong.security.annotation.UserLoginToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.dingdong.mysqlData.bean.Court;
import com.example.demo.dingdong.mysqlData.bean.Gym;
import com.example.demo.dingdong.mysqlData.handler.CourtHandler;
import com.example.demo.dingdong.mysqlData.handler.GymHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class SetRentableTimeController {
    @Autowired
    GymHandler gymHandler;

    @Autowired
    CourtHandler courtHandler;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class RentableTimeResponse {
        boolean success;
    }

    @Data
    private static class RentableTimeRequest {
        int gymId;
        int courtId;
        List<Integer> weekList;
        List<Integer> timeList;
    }

    @UserLoginToken
    @PostMapping("/api/manager/set")
    @ResponseBody
    public RentableTimeResponse SetRentableTime(@RequestBody RentableTimeRequest rentableTimeRequest) {
        //判断参数是否合法
        Gym gym = gymHandler.findById(rentableTimeRequest.gymId);
        if (gym == null) {
            return new RentableTimeResponse(false);
        }
        Court court;
        try {
            court = gym.getCourts().get(rentableTimeRequest.courtId);
        } catch (IndexOutOfBoundsException e) {
            return new RentableTimeResponse(false);
        }
        for (int weekNum : rentableTimeRequest.weekList) {
            if (weekNum < 0 || weekNum >= 6) {
                return new RentableTimeResponse(false);
            }
        }
        for (int timeNum : rentableTimeRequest.timeList) {
            if (timeNum < 0 || timeNum >= 13) {
                return new RentableTimeResponse(false);
            }
        }

        //设置场馆信息

        for (int i = 0; i < rentableTimeRequest.weekList.size(); i++) {

            courtHandler.changeCourtForbiddenStatusToOpposite(court, rentableTimeRequest.weekList.get(i), rentableTimeRequest.timeList.get(i));
        }
        return new RentableTimeResponse(true);
    }
}
