package com.umc.teamC.global.common.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public record ErrorReasonDTO(
        HttpStatus httpStatus,
        String code,
        String message,
        boolean isSuccess
) {
}
