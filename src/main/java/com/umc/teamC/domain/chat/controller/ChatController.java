package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChatController {

    private final ChatService chatService;

    // 메시지 보내기 컨트롤러
    @MessageMapping("/chat.message/{chatRoomId}")
    @SendTo("/topic/{chatRoomId}")
    public Map<String, Object> sendMessage(
            @PathVariable Long chatRoomId,
            Map<String, Object> message) {
        // 메시지 확인 로그
        log.info("Received message: {}", message);
        String sender = message.get("sender").toString();
        String content = message.get("content").toString();

        Chat message1 = Chat.builder()
                .sender(sender)
                .content(content)
                .chatId(chatRoomId)
                .build();

        Chat chat = chatService.saveMessage(message1);
        Map<String, Object> result = new HashMap<>();
        result.put("id", chat.getChatId());
        result.put("sender", chat.getSender());
        result.put("content", chat.getContent());
        return result;
    }

    @MessageMapping("/chat.addUser/{chatRoomId}")
    @SendTo("/topic/{chatRoomId}")
    public Chat addUser(@PathVariable Long chatRoomId, Chat chat) {
        chat.setId(chatRoomId);
        return chat;
    }
}
