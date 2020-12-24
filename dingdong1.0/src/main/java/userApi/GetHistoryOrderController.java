package userApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mysqlData.bean.Order;
import mysqlData.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetHistoryOrderController {
    @Autowired
    UserHandler userHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class HistoryOrderResponse {
        boolean success;
        List<Order> orders;
    }

    @GetMapping("/api/user/rent/history")
    @ResponseBody
    public HistoryOrderResponse GetHistoryOrder(@RequestAttribute("user") String username){
        return new HistoryOrderResponse(true, userHandler.getHistoryOrderByUsername(username));
    }
}
