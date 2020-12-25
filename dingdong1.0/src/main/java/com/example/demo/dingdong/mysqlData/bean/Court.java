package com.example.demo.dingdong.mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    Gym gym;
    int[][] timeStatus;    // 0:rentable, 1:rented, -1:not available

    public void setSpecificTimeStatus(int weekNum, int timeNum, int status){
        timeStatus[weekNum][timeNum] = status;
    }
}
