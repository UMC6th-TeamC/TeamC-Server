package com.umc.teamC.domain.chat.repository;

import com.umc.teamC.domain.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
