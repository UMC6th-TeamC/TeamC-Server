package com.umc.teamC.domain.user.controller;

import com.umc.teamC.domain.user.dto.UpdateUserDTO;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.jwt.JWTUtil;
import com.umc.teamC.domain.user.service.JoinService;
import com.umc.teamC.domain.user.service.UserService;
import com.umc.teamC.global.common.BaseResponse;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    private final JWTUtil jwtUtil;

    public UserController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    //닉네임(마이페이지) 조회
    @GetMapping("/user")
    public BaseResponse<String> userP() {
        String loggedInUsername = JWTUtil.getLoggedInUsername();
        String userNickname = userService.getUser(loggedInUsername);

        return BaseResponse.onSuccess(userNickname);
    }


    //닉네임 업데이트 구현
    @PatchMapping("/user")
    public BaseResponse<String> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {

        //현재 로그인 중인 userId를 가져옴
        String loggedInUsername = JWTUtil.getLoggedInUsername();
        User user = userService.updateUser(updateUserDTO, loggedInUsername);
        return BaseResponse.onSuccess("닉네임 변경 완료");
    }

}
