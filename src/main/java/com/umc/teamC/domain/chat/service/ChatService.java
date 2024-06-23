package com.umc.teamC.domain.chat.service;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.entity.ChatRoom;
import com.umc.teamC.domain.chat.repository.ChatRepository;
import com.umc.teamC.domain.chat.repository.ChatRoomRepository;
import com.umc.teamC.global.common.code.status.ErrorStatus;
import com.umc.teamC.global.common.exception.GeneralException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final SimpMessagingTemplate template;

    public void saveChatMessage(Chat chatMessage, Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._NOT_FOUND_CHAT_ROOM));
        chatMessage.updateChatRoom(chatRoom);
        chatRepository.save(chatMessage);

        template.convertAndSend("/topic/" + roomId, chatMessage);
    }

    public List<Chat> getAllMessages(Long chatRoomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._NOT_FOUND_CHAT_ROOM));
        return chatRepository.findAllByChatRoom(chatRoom);
    }
}

