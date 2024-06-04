package com.umc.domain;

import com.umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 9)
    private String student_id;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verification_id")
    private UserVerification userVerification;
}