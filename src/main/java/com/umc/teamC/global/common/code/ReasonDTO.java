package com.umc.teamC.global.common.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public record ReasonDTO(
        HttpStatus httpStatus,
        boolean isSuccess,
        String code,
        String message
) {
}
