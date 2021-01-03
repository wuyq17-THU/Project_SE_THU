package com.example.demo.dingdong.mysqlData.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String sportKind;
    @OneToMany
    List<Court> courts;
    @OneToMany
    List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
