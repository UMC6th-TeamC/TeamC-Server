package com.umc.teamC.global.common.code;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorReasonDTO {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess;
}
