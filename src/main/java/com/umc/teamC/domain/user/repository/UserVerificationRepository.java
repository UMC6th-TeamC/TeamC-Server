package com.umc.teamC.domain.user.repository;

import com.umc.teamC.domain.user.entity.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerificationRepository extends JpaRepository<UserVerification, Long> {

}