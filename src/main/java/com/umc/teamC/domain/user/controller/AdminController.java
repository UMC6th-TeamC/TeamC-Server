package com.umc.teamC.domain.user.controller;

import com.umc.teamC.global.common.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AdminController {
    @GetMapping("/admin")
    public BaseResponse<String> adminP() {
        return BaseResponse.onSuccess("토큰 전달 완료!");
    }

}
