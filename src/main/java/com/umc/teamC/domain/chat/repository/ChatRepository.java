package com.umc.teamC.domain.chat.repository;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findFirstByChatRoomOrderByCreatedAtDesc(ChatRoom chatRoom);

    List<Chat> findAllByChatRoom(ChatRoom chatRoom);
}
