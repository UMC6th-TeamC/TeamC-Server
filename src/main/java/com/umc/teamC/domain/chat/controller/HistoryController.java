package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("*")
class HistoryController {

    private final ChatService chatService;

    @GetMapping("/chat/history/{chatRoomId}")
    public List<Chat> getChatHistory(@PathVariable String chatRoomId) {
        return chatService.getAllMessages();
    }
}
