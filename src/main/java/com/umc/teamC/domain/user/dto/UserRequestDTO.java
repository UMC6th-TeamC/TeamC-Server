package com.umc.teamC.domain.user.dto;

import lombok.Getter;

public class UserRequestDTO {
    @Getter
    public static class JoinDTO {
        private String studentId;
        private String password;
        private String nickname;
        private Long verificationId;
    }

    @Getter
    public static class UpdateUserDTO {
        private String nickname;
    }

}
