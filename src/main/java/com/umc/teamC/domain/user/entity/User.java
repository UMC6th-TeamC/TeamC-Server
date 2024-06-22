package com.umc.teamC.domain.user.entity;

import com.umc.teamC.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nickname;

    private String role;


    public void update(String nickname) {
        this.nickname = nickname;
    }
}


