package mysqlData.handler;

import mysqlData.bean.Court;
import mysqlData.repository.CourtRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;

@Service
public class CourtHandler {
    @Resource
    private CourtRepository courtRepository;

    public boolean changeCourtStatusToRented(Court court, int weekNum, int timeNum) {
        if (court.getTime_status()[weekNum][timeNum] != 0) return false;
        court.setSpecificTimeStatus(weekNum,timeNum,1);
        return true;
    }

    public void changeCourtForbiddenStatusToOpposite(Court court, int weekNum, int timeNum) {
        if (court.getTime_status()[weekNum][timeNum] != 1) {
            if (court.getTime_status()[weekNum][timeNum] == 0) {
                court.setSpecificTimeStatus(weekNum,timeNum,1);
            } else {
                court.setSpecificTimeStatus(weekNum,timeNum,0);
            }
        }
    }

    public void changeAllCourtStatusToNextWeek() {
        Iterable<Court> courts = courtRepository.findAll();
        for (Court court : courts) {
            int[][] timeStatus = new int[court.getTime_status().length][court.getTime_status()[0].length];
            for (int i = 0; i < timeStatus.length; i++) {
                for (int j = 0; j < timeStatus[0].length; j++) {
                    timeStatus[i][j] = 0;
                }
            }
            court.setTime_status(timeStatus);
        }
    }
}
