package com.ms.user.service.UserService.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "micro_users")
@Data
@RequiredArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer userId;
    private String name;
    private String email;
    private String about;


    @Transient
    private List<Rating> ratings;
}
