package com.umc.teamC.domain.user.controller;

import com.umc.teamC.domain.user.dto.JoinDTO;
import com.umc.teamC.domain.user.service.JoinService;
import com.umc.teamC.domain.user.converter.UserConverter;
import com.umc.teamC.global.common.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public BaseResponse<String> joinProcess(JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        String userData = "회원가입 완료 (" + joinDTO.getUsername() + ")";
        return BaseResponse.onSuccess(userData);
    }
    /*public String joinProcess(JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);

        return "ok";
    }*/
}
