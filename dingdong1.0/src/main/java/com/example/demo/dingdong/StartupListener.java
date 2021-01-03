package com.example.demo.dingdong;

import com.example.demo.dingdong.mysqlData.bean.Comment;
import com.example.demo.dingdong.mysqlData.bean.Court;
import com.example.demo.dingdong.mysqlData.bean.Gym;
import com.example.demo.dingdong.mysqlData.bean.User;
import com.example.demo.dingdong.mysqlData.repository.CourtRepository;
import com.example.demo.dingdong.mysqlData.repository.GymRepository;
import com.example.demo.dingdong.mysqlData.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StartupListener {

    @Resource
    private UserRepository userRepository;

    @Resource
    private GymRepository gymRepository;

    @Resource
    private CourtRepository courtRepository;


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

        if(gymRepository.findBySportKind("tennis") == null){
            log.info("创建网球馆");
            initialGymDb("tennis");
        }
        if(gymRepository.findBySportKind("badminton") == null){
            log.info("创建羽毛球馆");
            initialGymDb("badminton");
        }
    }

    private void initialGymDb(String kind) {
        List<Court> courtList = new ArrayList<>();
        Gym gym = Gym.builder()
                .sportKind(kind)
                .courts(courtList)
                .comments(new ArrayList<Comment>()).build();
        gymRepository.save(gym);

        int weeklength = 7;
        int timelength = 14;
        String[] templine = new String[weeklength];
        for (int i = 0; i < timelength; i++) {
            templine[i] = "0";
        }
        String temp = String.join(",",templine);
        String[] temprow = new String[timelength];
        for(int i = 0; i< weeklength; i++){
            temprow[i] = temp;
        }

        String beginTimeStatus = String.join("#", temprow);

        courtList.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
        courtList.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
        courtList.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
        courtRepository.saveAll(courtList);
        gym.setCourts(courtList);
        gymRepository.save(gym);
    }

}
