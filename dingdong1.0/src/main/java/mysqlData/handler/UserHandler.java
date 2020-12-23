package mysqlData.handler;

import mysqlData.bean.Order;
import mysqlData.bean.User;
import mysqlData.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserHandler {
    @Resource
    private UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public String getPwByName(String user_name){
        return userRepository.findByUser_name(user_name).getPassword();
    }

    public Iterable<Order> getOrdersByName(String user_name){
        return userRepository.findByUser_name(user_name).getHistory_order();
    }
}
