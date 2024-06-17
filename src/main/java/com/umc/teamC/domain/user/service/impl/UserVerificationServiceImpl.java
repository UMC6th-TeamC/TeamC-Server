package com.umc.teamC.domain.user.service.impl;

import com.umc.teamC.domain.user.converter.UserVerificationConverter;
import com.umc.teamC.domain.user.dto.UserVerificationRequestDTO;
import com.umc.teamC.domain.user.entity.UserVerification;
import com.umc.teamC.domain.user.repository.UserVerificationRepository;
import com.umc.teamC.global.common.code.status.ErrorStatus;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.repository.UserRepository;
import com.umc.teamC.domain.user.service.UserVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserVerificationServiceImpl implements UserVerificationService {
    private final UserVerificationRepository userVerificationRepository;

    @Override
    public UserVerification createUserVerification(Long verificationId, UserVerificationRequestDTO.JoinUserVerificationDTO joinUserVerificationDTO) {
        UserVerification userVerification = UserVerificationConverter.toUserVerification(joinUserVerificationDTO);
        return userVerificationRepository.save(userVerification);
    }

}
