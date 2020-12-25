package managerApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.bean.Court;
import mysqlData.bean.Gym;
import mysqlData.handler.CourtHandler;
import mysqlData.handler.GymHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    private static class SetParams {
        int weekNum;
        int timeNum;
    }

    private static class RentableTimeRequest {
        int gymId;
        int courtId;
        List<SetParams> setList;
    }

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
        for (SetParams params : rentableTimeRequest.setList) {
            if ((params.weekNum < 0 || params.weekNum >= 7) || (params.timeNum < 0 || params.timeNum >= 14)) {//todo: 每天的时间未直接确定，数据可能需要更改
                return new RentableTimeResponse(false);
            }
        }

        //设置场馆信息
        for (SetParams params : rentableTimeRequest.setList) {
            courtHandler.changeCourtForbiddenStatusToOpposite(court, params.weekNum, params.timeNum);
        }
        return new RentableTimeResponse(true);
    }
}
