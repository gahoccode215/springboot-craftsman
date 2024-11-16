package com.gahoccode.nyano.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "java_user_001")
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String email;
}
