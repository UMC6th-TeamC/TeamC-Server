package com.umc.teamC.global.common.code;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDTO {
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess;

}
