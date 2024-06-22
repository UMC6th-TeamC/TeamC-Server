package com.umc.teamC.domain.user.controller;


import com.umc.teamC.global.common.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {
    @GetMapping("/")
    public BaseResponse<String> MainP() {
        return BaseResponse.onSuccess("성공!");
    }
}
