package com.umc.teamC.domain.user.converter;

import com.umc.teamC.domain.user.dto.UserVerificationRequestDTO;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.entity.UserVerification;
import com.umc.teamC.domain.user.dto.UserResponseDTO;

public class UserConverter {
    //User를 빌더패턴으로
    //Converter안의 메소드 명은 to(리턴시켜주는 것)

    // UserVerification 엔티티를 User 엔티티로 변환하는 메소드
    public User toUser(UserVerificationRequestDTO.JoinUserVerificationDTO userVerificationRequestDTO) {
        return User.builder()
                .student_id(userVerificationRequestDTO.getStudentId())
                .password(userVerificationRequestDTO.getPassword())
                .nickname("DefaultNickname") // 기본 닉네임 설정, 필요에 따라 변경 가능
                //.userVerification(userVerificationRequestDTO.)
                .build();
    }

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUser_id())
                .build();
    }

    public static UserResponseDTO.UserPreviewDTO toUserPreviewDTO(User user) {
        return UserResponseDTO.UserPreviewDTO.builder()
                .userId(user.getUser_id())
                .nickname(user.getNickname())
                .updatedAt(user.getUpdatedAt())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
