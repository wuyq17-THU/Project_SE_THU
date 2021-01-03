package com.example.demo.dingdong.mysqlData.bean;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    public enum UserType {
        M,
        U,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    UserType userType;     //"U" or "M"
    @OneToMany
    @NonNull
    @Builder.Default
    List<UserOrder> historyUserOrder = new ArrayList<>();

    public void addOrder(UserOrder userOrder){
        historyUserOrder.add(userOrder);
    }
}
