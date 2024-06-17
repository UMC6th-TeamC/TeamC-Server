package com.umc.teamC.domain.user.controller;

import com.umc.teamC.domain.user.dto.UserVerificationRequestDTO;
import com.umc.teamC.domain.user.dto.UserVerificationResponseDTO;
import com.umc.teamC.domain.user.service.UserVerificationService;
import com.umc.teamC.global.common.BaseResponse;
import com.umc.teamC.domain.user.converter.UserVerificationConverter;
import com.umc.teamC.domain.user.entity.UserVerification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin
public class UserVerificationController {
    private final UserVerificationService userVerificationService;
    @PostMapping("/users/{userId}/posts")
    public BaseResponse<UserVerificationResponseDTO.JoinUserVerificationResultDTO> createUserVerification(@PathVariable Long verificationId, @RequestBody UserVerificationRequestDTO.JoinUserVerificationDTO joinUserVerificationDTO) {
        UserVerification userVerification = userVerificationService.createUserVerification(verificationId, joinUserVerificationDTO);
        return BaseResponse.onSuccess(UserVerificationConverter.toJoinUserVerificationResultDTO(userVerification));
    }

}
