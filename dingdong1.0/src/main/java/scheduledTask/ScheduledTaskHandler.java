package scheduledTask;


import mysqlData.handler.CourtHandler;
import mysqlData.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduledTaskHandler {
    @Autowired
    CourtHandler courtHandler;

    @Autowired
    OrderHandler orderHandler;

    @Scheduled(cron = "0 0 0 ? * MON")
    public void courtStatusRefresh(){
        courtHandler.changeAllCourtStatusToNextWeek();
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void ordersStatusRefresh(){
        orderHandler.changeAndDeleteFinishedOrders();
    }
}
