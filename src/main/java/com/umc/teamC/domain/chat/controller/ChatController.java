package com.umc.teamC.domain.chat.controller;


import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChatController {

    private final ChatService chatService;

    //메세지 보내기 컨트롤러
    @MessageMapping("/chat.message")
    @SendTo("/topic/public")
    public Map<String, Object> sendMessage(Map<String, Object> message) {
//        System.out.println(message);
        String sender = message.get("sender").toString();
        String content = message.get("content").toString();
        Chat message1 = Chat.builder()
                .sender(sender)
                .content(content)
                .build();
        Chat chat = chatService.saveMessage(message1);
        Map<String, Object> result = new HashMap<>();
        result.put("id", chat.getId());
        result.put("sender", chat.getSender());
        result.put("content", chat.getContent());
        return result;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Chat addUser(Chat chat) {
        return chat;
    }
}
