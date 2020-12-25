package com.example.demo.dingdong;

import com.example.demo.dingdong.mysqlData.bean.User;
import com.example.demo.dingdong.mysqlData.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class StartupListener {

    @Resource
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        if (userRepository.findByUsername("root") == null) {
            log.info("创建 root 用户");
            User user = User.builder()
                    .password("root")
                    .username("root")
                    .userType(User.UserType.M)
                    .build();
            userRepository.save(user);
        }
    }

}
