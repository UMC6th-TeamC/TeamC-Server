package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.entity.ChatRoom;
import com.umc.teamC.domain.chat.repository.ChatRoomRepository;
import com.umc.teamC.domain.chat.service.ChatService;
import com.umc.teamC.global.common.code.status.ErrorStatus;
import com.umc.teamC.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
//@CrossOrigin("*")
public class ChatController {

    private final ChatService chatService;
    private final ChatRoomRepository chatRoomRepository;

    // 메시지 보내기 컨트롤러
    @MessageMapping("/chat.message/{chatRoomId}")
    @SendTo("/topic")
    public Map<String, Object> sendMessage(
            @PathVariable Long chatRoomId,
            Map<String, Object> message) {
        // 메시지 확인 로그
        log.info("Received message: {}", message);
        String sender = message.get("sender").toString();
        String content = message.get("content").toString();

        Chat chatMessage = Chat.builder()
                .sender(sender)
                .content(content)
                .build();

        chatService.saveChatMessage(chatMessage, chatRoomId);

        Map<String, Object> result = new HashMap<>();
        result.put("id", chatMessage.getChatId());
        result.put("sender", chatMessage.getSender());
        result.put("content", chatMessage.getContent());
        return result;
    }

    @MessageMapping("/chat.addUser/{chatRoomId}")
    @SendTo("/topic")
    public Chat addUser(Chat chat, @PathVariable Long chatRoomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow(() -> new GeneralException(ErrorStatus._NOT_FOUND_CHAT_ROOM));
        chat.updateChatRoom(chatRoom);
        return chat;
    }
}
