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

        if (gymRepository.findBySportKind("tennis") == null) {
            log.info("创建网球馆");
            List<Court> courtList1 = new ArrayList<>();
            Gym gym = Gym.builder()
                    .sportKind("tennis")
                    .courts(courtList1)
                    .comments(new ArrayList<Comment>()).build();
            gymRepository.save(gym);

            int weeklength = 7;
            int timelength = 14;
            String[] templine = new String[timelength];
            for (int i = 0; i < timelength; i++) {
                templine[i] = "0";
            }
            String temp = String.join(",", templine);
            String[] temprow = new String[weeklength];
            for (int i = 0; i < weeklength; i++) {
                temprow[i] = temp;
            }

            String beginTimeStatus = String.join("#", temprow);

            courtList1.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtList1.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtList1.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtRepository.saveAll(courtList1);
            gym.setCourts(courtList1);
            gymRepository.save(gym);
        }
        if (gymRepository.findBySportKind("badminton") == null) {
            log.info("创建羽毛球馆");
            List<Court> courtList2 = new ArrayList<>();
            Gym gym = Gym.builder()
                    .sportKind("badminton")
                    .courts(courtList2)
                    .comments(new ArrayList<Comment>()).build();
            gymRepository.save(gym);

            int weeklength = 7;
            int timelength = 14;
            String[] templine = new String[timelength];
            for (int i = 0; i < timelength; i++) {
                templine[i] = "0";
            }
            String temp = String.join(",", templine);
            String[] temprow = new String[weeklength];
            for (int i = 0; i < weeklength; i++) {
                temprow[i] = temp;
            }

            String beginTimeStatus = String.join("#", temprow);

            courtList2.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtList2.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtList2.add(Court.builder().gym(gym).timeStatus(beginTimeStatus).build());
            courtRepository.saveAll(courtList2);
            gym.setCourts(courtList2);
            gymRepository.save(gym);
        }
    }

    private void initialGymDb(String kind) {

    }

}
