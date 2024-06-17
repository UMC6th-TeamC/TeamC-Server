package com.umc.teamC.domain.user.dto;

import com.umc.teamC.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {
    @Getter //필드에 접근
    @AllArgsConstructor //모든 필드를 인자로 받는 생성자를 자동으로 생성
    @NoArgsConstructor //매개변수가 없는 기본 생성자를 자동으로 생성
    @Builder //빌더 패턴을 쉽게 적용
    public static class JoinResultDTO {
        private Long userId;
        private LocalDateTime createAt; //생성시간
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserPreviewDTO {

        private Long userId;
        private String studentId;
        private String nickname;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long verificationId;
    }


    public static UserPreviewDTO toUserPreviewDTO(User user) {
        return UserPreviewDTO.builder()
                .userId(user.getUser_id())
                .studentId(user.getStudent_id())
                .nickname(user.getNickname())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .verificationId(user.getUserVerification().getVerification_id())
                .build();

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserPreviewListDTO {
        List<UserPreviewDTO> userPreviewDTOList;
    }
}
