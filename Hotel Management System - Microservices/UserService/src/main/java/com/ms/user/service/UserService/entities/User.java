package com.ms.user.service.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "micro_users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class User {
    @Id
    @Column(name = "ID")
    private Integer userId;
    private String name;
    private String email;
    private String about;
}
