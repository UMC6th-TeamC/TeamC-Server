package com.umc.teamC.domain.user.converter;


import com.umc.teamC.domain.user.entity.UserVerification;
import com.umc.teamC.domain.user.dto.UserVerificationResponseDTO;
import com.umc.teamC.domain.user.dto.UserVerificationRequestDTO;


public class UserVerificationConverter {

    public static UserVerification toUserVerification(UserVerificationRequestDTO.JoinUserVerificationDTO joinUserVerificationDTO) {
        return UserVerification.builder()
                .student_id(joinUserVerificationDTO.getStudentId())
                .password(joinUserVerificationDTO.getPassword())
                .code(joinUserVerificationDTO.getCode())
                .requested_at(joinUserVerificationDTO.getRequestedAt())
                .expired_at(joinUserVerificationDTO.getExpiredAt())
                .build();
    }

    public static UserVerificationResponseDTO.JoinUserVerificationResultDTO toJoinUserVerificationResultDTO(UserVerification userVerification) {
        return UserVerificationResponseDTO.JoinUserVerificationResultDTO.builder()
                .verificationId(userVerification.getVerification_id())
                .build();
    }

    public static UserVerificationResponseDTO.UserVerificationPreviewDTO toUserVerificationPreviewDTO(UserVerification userVerification) {
        return UserVerificationResponseDTO.UserVerificationPreviewDTO.builder()
                .verificationId(userVerification.getVerification_id())
                .studentId(userVerification.getStudent_id())
                .code(userVerification.getCode())
                .isVerified(userVerification.is_verified())
                .requestedAt(userVerification.getRequested_at())
                .expiredAt(userVerification.getExpired_at())
                .build();
    }


}
