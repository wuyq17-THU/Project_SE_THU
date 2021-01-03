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
        if (court.getVectorTimeStatus()[weekNum][timeNum] != 0) return false;
        court.setVectorTimeStatus(weekNum, timeNum, 1);
        return true;
    }

    public void changeCourtForbiddenStatusToOpposite(Court court, int weekNum, int timeNum) {
        if (court.getVectorTimeStatus()[weekNum][timeNum] != 1) {
            if (court.getVectorTimeStatus()[weekNum][timeNum] == 0) {
                court.setVectorTimeStatus(weekNum, timeNum, 1);
            } else {
                court.setVectorTimeStatus(weekNum, timeNum, 0);
            }
        }
    }

    public void changeAllCourtStatusToNextWeek() {
        Iterable<Court> courts = courtRepository.findAll();
        for (Court court : courts) {
            int weeklength = court.getVectorTimeStatus().length;
            int timelength = court.getVectorTimeStatus()[0].length;
            String[] templine = new String[weeklength];
            for (int i = 0; i < timelength; i++) {
                templine[i] = "0";
            }
            String temp = String.join(",",templine);
            String[] temprow = new String[timelength];
            for(int i = 0; i< weeklength; i++){
                temprow[i] = temp;
            }
            court.setTimeStatus(String.join("#", temprow));
        }
    }
}
