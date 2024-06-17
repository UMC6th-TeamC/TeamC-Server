package com.umc.teamC.domain.email.controller;

import com.umc.teamC.domain.email.dto.EmailRequestDto;
import com.umc.teamC.domain.email.service.EmailService;
import com.umc.teamC.global.common.BaseResponse;
import com.umc.teamC.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/id")
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;
    private final RedisUtil redisUtil;

    // 인증번호 전송
    @PostMapping("/mail/check")
    public BaseResponse<Object> emailConfirm(@RequestBody EmailRequestDto.EmailCheckRequest emailCheckRequest) throws Exception {
        String confirm = emailService.sendSimpleMessage(emailCheckRequest.getEmail());
        if (confirm.isEmpty()) {
            return BaseResponse.onFailure("인증번호 전송 실패");
        } else {
            return BaseResponse.onSuccess("인증번호 전송 성공");
        }
    }

    // 인증번호 확인
    @PostMapping("/mail/authentication")
    public BaseResponse<Object> emailAuthentication(@RequestBody EmailRequestDto.EmailAuthRequest emailAuthRequest) {
        String email = emailAuthRequest.getEmail();
        String certificationNum = emailAuthRequest.getCertificationNum();

        // Redis에서 인증 번호 조회
        String storedCertificationNum = (String) redisUtil.get(email);

        if (storedCertificationNum != null && storedCertificationNum.equals(certificationNum)) {
            return BaseResponse.onSuccess("인증번호가 일치합니다.");
        } else {
            return BaseResponse.onFailure("인증번호가 일치하지 않습니다.");
        }
    }
}