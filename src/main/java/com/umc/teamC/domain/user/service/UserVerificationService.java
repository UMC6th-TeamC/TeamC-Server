package com.umc.teamC.domain.user.service;

import com.umc.teamC.domain.user.entity.UserVerification;
import com.umc.teamC.domain.user.dto.UserVerificationRequestDTO;

public interface UserVerificationService {
    UserVerification createUserVerification(Long verificationId, UserVerificationRequestDTO.JoinUserVerificationDTO joinUserVerificationDTO);

}
