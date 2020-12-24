package mysqlData.handler;

import mysqlData.bean.Court;
import mysqlData.repository.CourtRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourtHandler {
    @Resource
    private CourtRepository courtRepository;

    public boolean changeCourtStatus(Court court, int weeknum, int timenum){
        if(court.getTime_status()[weeknum][timenum] != 0) return false;
        court.getTime_status()[weeknum][timenum] = 1;
        return true;
    }
}
