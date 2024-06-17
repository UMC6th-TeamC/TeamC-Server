package com.umc.teamC.domain.user.controller;

import com.umc.teamC.global.common.BaseResponse;
import com.umc.teamC.domain.user.converter.UserConverter;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.dto.UserRequestDTO;
import com.umc.teamC.domain.user.dto.UserResponseDTO;
import com.umc.teamC.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
    //구현할 메서드 작성
    private final UserService userService;

    @PostMapping("/users")
    public BaseResponse<UserResponseDTO.JoinResultDTO> createUser(@RequestBody UserRequestDTO.JoinDTO joinDTO) {
        User user = userService.createUser(joinDTO);
        return BaseResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }


}
