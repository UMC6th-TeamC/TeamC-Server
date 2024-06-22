package com.umc.teamC.domain.chat.converter;

import com.umc.teamC.domain.chat.dto.ChatRoomDto;
import com.umc.teamC.domain.chat.entity.ChatRoom;

import java.util.List;

public class ChatRoomConverter {

//    public static ChatRoomDto.ChatRoomListResponseDto toChatRoomListResponseDto(List<ChatRoom> chatRoomList) {
//        List<ChatRoomDto.ChatRoomResponseDto> chatRoomResponseDtoList = chatRoomList.stream()
//                .map(ChatRoomConverter::toChatRoomResponseDto)
//                .toList();
//        return ChatRoomDto.ChatRoomListResponseDto.builder()
//                .ChatRoomResponseDtoList(chatRoomResponseDtoList)
//                .build();
//    }

    public static ChatRoomDto.ChatRoomResponseDto toChatRoomResponseDto(ChatRoom chatRoom, String lastMessage, Integer memberCount) {
        return ChatRoomDto.ChatRoomResponseDto.builder()
                .chatRoomId(chatRoom.getRoomId())
                .dateTime(chatRoom.getDateTime())
                .region(chatRoom.getRegion())
                .lastMessage(lastMessage)
                .memberCount(memberCount)
                .build();
    }
}
