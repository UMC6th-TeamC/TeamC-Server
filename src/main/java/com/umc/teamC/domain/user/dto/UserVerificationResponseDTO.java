package com.umc.teamC.domain.user.dto;

import com.umc.teamC.domain.user.entity.UserVerification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserVerificationResponseDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class JoinUserVerificationResultDTO {
        private Long verificationId;
        private LocalDateTime requestedAt; // 생성시간
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserVerificationPreviewDTO {
        private Long verificationId;
        private String studentId;
        private String code;
        private boolean isVerified;
        private LocalDateTime requestedAt;
        private LocalDateTime expiredAt;
    }

    public static UserVerificationPreviewDTO toUserVerificationPreviewDTO(UserVerification verification) {
        return UserVerificationPreviewDTO.builder()
                .verificationId(verification.getVerification_id())
                .studentId(verification.getStudent_id())
                .code(verification.getCode())
                .isVerified(verification.is_verified())
                .requestedAt(verification.getRequested_at())
                .expiredAt(verification.getExpired_at())
                .build();
    }
}
