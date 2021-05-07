package com.example.todoapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;


}
