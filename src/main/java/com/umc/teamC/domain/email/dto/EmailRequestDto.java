package com.umc.teamC.domain.email.dto;
import lombok.Getter;

public class EmailRequestDto {

    @Getter
    public static class EmailAuthRequest {
        private String email;
        private String certificationNum;
    }

    @Getter
    public static class EmailCheckRequest {
        private String email;
    }
}