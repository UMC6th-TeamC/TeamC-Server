package com.umc.teamC.domain.user.repository;

import com.umc.teamC.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);

    // 특정 studentId로 UserVerification을 찾기 위한 메소드
    //Optional<UserVerification> findByStudentId(String studentId);
}