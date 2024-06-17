package com.umc.teamC.domain.chat.service;

import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    SimpMessagingTemplate template;

    public Chat saveMessage(Chat chat) {
//        template.convertAndSend("/topic/public" + sessionId, message);
        return chatRepository.save(chat);
    }

    public List<Chat> getAllMessages() {
        return chatRepository.findAll();
    }
}
