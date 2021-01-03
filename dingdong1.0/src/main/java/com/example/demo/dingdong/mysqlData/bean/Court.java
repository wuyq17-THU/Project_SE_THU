package com.example.demo.dingdong.mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    Gym gym;
    String timeStatus;    // 0:rentable, 1:rented, -1:not available, week divided by '#' and time divided by ','

    public int[][] getVectorTimeStatus() {
        String[] midTimeStatus = timeStatus.split("#");
        int[][] vectorizedTimeStatus = new int[midTimeStatus.length][];
        for (int i = 0; i < midTimeStatus.length; i++) {
            String[] afterMid = midTimeStatus[i].split(",");
            vectorizedTimeStatus[i] = new int[afterMid.length];
            for (int j = 0; j < afterMid.length; j++) {
                vectorizedTimeStatus[i][j] = Integer.parseInt(afterMid[j]);
            }
        }
        return vectorizedTimeStatus;
    }

    public void setVectorTimeStatus(int weekNum, int timeNum, int status) {
        String[] midTimeStatus = timeStatus.split("#");
        int[][] vectorizedTimeStatus = new int[midTimeStatus.length][];
        for (int i = 0; i < midTimeStatus.length; i++) {
            String[] afterMid = midTimeStatus[i].split(",");
            vectorizedTimeStatus[i] = new int[afterMid.length];
            for (int j = 0; j < afterMid.length; j++) {
                vectorizedTimeStatus[i][j] = Integer.parseInt(afterMid[j]);
            }
        }
        vectorizedTimeStatus[weekNum][timeNum] = status;
        midTimeStatus[weekNum] = Arrays.stream(vectorizedTimeStatus[weekNum]).mapToObj(String::valueOf).collect(Collectors.joining(","));
        timeStatus = String.join("#",midTimeStatus);
    }
}
