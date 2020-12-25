package mysqlData.handler;

import mysqlData.bean.Order;
import mysqlData.bean.User;
import mysqlData.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserHandler {
    @Resource
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public String getPwByName(String user_name) {
        return userRepository.findByUser_name(user_name).getPassword();
    }

    public User getUserByName(String user_name) {
        return userRepository.findByUser_name(user_name);
    }

    public void addHistoryOrderByUsername(String username, Order order) {
        getUserByName(username).getHistory_order().add(order);
    }

    public List<Order> getHistoryOrderByUsername(String username) {
        return getUserByName(username).getHistory_order();
    }
}
