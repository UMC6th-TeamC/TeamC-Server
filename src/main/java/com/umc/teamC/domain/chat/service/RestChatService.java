package com.umc.teamC.domain.chat.service;

import com.umc.teamC.domain.chat.dto.ChatRoomDto;
import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.entity.ChatRoom;
import com.umc.teamC.domain.chat.repository.ChatRepository;
import com.umc.teamC.domain.chat.repository.ChatRoomRepository;
import com.umc.teamC.domain.chat.repository.ChatRoomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RestChatService {

    private final ChatRoomUserRepository chatRoomUserRepository;
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoomDto.ChatRoomResponseDto> getChatRoomList(Long userId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findChatRoomsByUserId(userId);

        List<ChatRoomDto.ChatRoomResponseDto> chatRoomResponseDtoList = chatRoomList.stream()
                .map(chatRoom -> {
                    Chat chat = chatRepository.findFirstByChatRoomOrderByCreatedAtDesc(chatRoom);

                    Integer count = chatRoomUserRepository.countByChatRoom(chatRoom);

                    String lastMessageContent = (chat != null) ? chat.getContent() : null;
                    return ChatRoomDto.ChatRoomResponseDto.builder()
                            .chatRoomId(chatRoom.getRoomId())
                            .dateTime(chatRoom.getDateTime())
                            .region(chatRoom.getRegion())
                            .lastMessage(lastMessageContent)
                            .memberCount(count)
                            .build();
                }).collect(Collectors.toList());

        return chatRoomResponseDtoList;
    }

}
