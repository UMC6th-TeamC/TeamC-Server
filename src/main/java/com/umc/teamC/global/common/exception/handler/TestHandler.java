package com.umc.teamC.global.common.exception.handler;


import com.umc.teamC.global.common.code.BaseErrorCode;
import com.umc.teamC.global.common.exception.GeneralException;

public class TestHandler extends GeneralException {
    public TestHandler(BaseErrorCode code) {
        super(code);
    }
}
