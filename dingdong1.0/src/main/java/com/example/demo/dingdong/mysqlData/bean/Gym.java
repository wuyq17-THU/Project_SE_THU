package com.example.demo.dingdong.mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String sport_kind;
    @OneToMany
    List<Court> courts;
    @OneToMany
    List<Comment> comments;
}
