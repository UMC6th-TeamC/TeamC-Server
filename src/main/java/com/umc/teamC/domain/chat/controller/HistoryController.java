package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
class HistoryController {

    private final ChatService chatService;

    @GetMapping("/chat/history")
    public List<Chat> getChatHistory() {
        return chatService.getAllMessages();
    }
}
