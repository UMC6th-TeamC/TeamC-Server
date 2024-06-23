package com.umc.teamC.domain.chat.repository;

import com.umc.teamC.domain.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    // 사용자 ID로 채팅방 목록을 조회하는 쿼리 메서드
    @Query("SELECT cr FROM ChatRoom cr JOIN cr.chatRoomUserList cru WHERE cru.user.id = :userId")
    List<ChatRoom> findChatRoomsByUserId(@Param("userId") Long userId);}
