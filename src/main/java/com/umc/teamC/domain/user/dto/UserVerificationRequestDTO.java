package com.umc.teamC.domain.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class UserVerificationRequestDTO {
    @Getter
    public static class JoinUserVerificationDTO{
        private String studentId;
        private String password;
        private String code;
        private LocalDateTime requestedAt;
        private LocalDateTime expiredAt;
    }
}