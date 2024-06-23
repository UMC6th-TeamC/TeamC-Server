package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.service.ChatService;
import com.umc.teamC.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
@RequiredArgsConstructor
//@CrossOrigin("*")
public class ChatController {

    private final RedisUtil redisUtil;

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

        Chat message1 = Chat.builder()
                .sender(sender)
                .content(content)
                .chatId(chatRoomId)
                .build();

        // Redis에 메시지 저장
        String messageId = UUID.randomUUID().toString();
        String redisKey = "chat:" + chatRoomId + ":" + messageId;
        redisUtil.save(redisKey, message1, 1L, TimeUnit.DAYS);

        Map<String, Object> result = new HashMap<>();
        result.put("id", messageId);
        result.put("sender", message1.getSender());
        result.put("content", message1.getContent());
        return result;
    }

    @MessageMapping("/chat.addUser/{chatRoomId}")
    @SendTo("/topic")
    public Chat addUser(Chat chat, @PathVariable Long chatRoomId) {
        chat.setId(chatRoomId);
        return chat;
    }
}
