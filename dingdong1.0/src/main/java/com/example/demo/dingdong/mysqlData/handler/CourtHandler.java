package com.example.demo.dingdong.mysqlData.handler;

import com.example.demo.dingdong.mysqlData.bean.Court;
import com.example.demo.dingdong.mysqlData.repository.CourtRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourtHandler {
    @Resource
    private CourtRepository courtRepository;

    public boolean changeCourtStatusToRented(Court court, int weekNum, int timeNum) {
        if (court.getTimeStatus()[weekNum][timeNum] != 0) return false;
        court.setSpecificTimeStatus(weekNum,timeNum,1);
        return true;
    }

    public void changeCourtForbiddenStatusToOpposite(Court court, int weekNum, int timeNum) {
        if (court.getTimeStatus()[weekNum][timeNum] != 1) {
            if (court.getTimeStatus()[weekNum][timeNum] == 0) {
                court.setSpecificTimeStatus(weekNum,timeNum,1);
            } else {
                court.setSpecificTimeStatus(weekNum,timeNum,0);
            }
        }
    }

    public void changeAllCourtStatusToNextWeek() {
        Iterable<Court> courts = courtRepository.findAll();
        for (Court court : courts) {
            int[][] timeStatus = new int[court.getTimeStatus().length][court.getTimeStatus()[0].length];
            for (int i = 0; i < timeStatus.length; i++) {
                for (int j = 0; j < timeStatus[0].length; j++) {
                    timeStatus[i][j] = 0;
                }
            }
            court.setTimeStatus(timeStatus);
        }
    }
}
