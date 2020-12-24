package userApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.bean.Court;
import mysqlData.bean.Gym;
import mysqlData.handler.GymHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@RestController
public class GetCourtInfoController {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CourtInfoResponse {
        boolean success;
        int[][] courts;
        String[] dateInfo;
    }

    private static class CourtIndexRequest {
        int gymId;
        int courtId;
    }

    @Autowired
    GymHandler gymHandler;

    @PostMapping("/api/user/court")
    @ResponseBody
    public CourtInfoResponse GetCourtInfo(@RequestBody CourtIndexRequest courtIndexRequest) {
        Gym gym = gymHandler.findById(courtIndexRequest.gymId);
        if (gym == null) {
            return new CourtInfoResponse(false, null, null);
        }
        Court court;
        try {
            court = gym.getCourts().get(courtIndexRequest.courtId);
        } catch (IndexOutOfBoundsException e) {
            return new CourtInfoResponse(false, null, null);
        }
        String[] dateInfo = new String[7];
        LocalDate nextMonday = LocalDate.now().plusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        for(int i = 0; i < 7; i++){
            dateInfo[i] = nextMonday.plusDays(i).toString();
        }
        return new CourtInfoResponse(true, court.getTime_status(), dateInfo);
    }
}
