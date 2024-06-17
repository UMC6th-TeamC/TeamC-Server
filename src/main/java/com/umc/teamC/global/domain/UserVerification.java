package com.umc.teamC.global.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verification_id;

    @Column(nullable = false, length = 9)
    private String student_id;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 6)
    private String code;

    @Column(nullable = false)
    private boolean is_verified;

    @Column(nullable = false)
    private LocalDateTime requested_at;

    @Column(nullable = false)
    private LocalDateTime expired_at;

    @OneToOne(mappedBy = "userVerification")
    private User user;
}