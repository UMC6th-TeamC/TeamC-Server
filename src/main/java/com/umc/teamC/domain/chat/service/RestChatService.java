package com.umc.teamC.domain.chat.service;

import com.umc.teamC.domain.chat.converter.ChatRoomConverter;
import com.umc.teamC.domain.chat.dto.ChatRoomDto;
import com.umc.teamC.domain.chat.entity.Chat;
import com.umc.teamC.domain.chat.entity.ChatRoom;
import com.umc.teamC.domain.chat.repository.ChatRepository;
import com.umc.teamC.domain.chat.repository.ChatRoomRepository;
import com.umc.teamC.domain.chat.repository.ChatRoomUserRepository;
import com.umc.teamC.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestChatService {

    private final ChatRoomUserRepository chatRoomUserRepository;
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    // 채팅방 목록 조회 - 채팅방 지역, 시간, 마지막 메세지 전달
    public List<ChatRoomDto.ChatRoomResponseDto> getChatRoomList(User user) {
        List<ChatRoom> chatRoomList = chatRoomUserRepository.findAllChatRoomByUser(user);
        List<ChatRoomDto.ChatRoomResponseDto> chatRoomResponseDtoList = new ArrayList<>();
        for (ChatRoom chatRoom : chatRoomList) {
            Chat chat = chatRepository.findFirstByChatRoomOrderByCreatedAtDesc(chatRoom);
            Integer count = chatRoomUserRepository.countByChatRoom(chatRoom);
            ChatRoomDto.ChatRoomResponseDto chatRoomResponseDto = ChatRoomConverter.toChatRoomResponseDto(chatRoom, chat.getContent(), count);
            chatRoomResponseDtoList.add(chatRoomResponseDto);
        }
        return chatRoomResponseDtoList;
    }
}
