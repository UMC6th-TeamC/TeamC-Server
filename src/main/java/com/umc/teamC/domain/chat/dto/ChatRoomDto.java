package com.umc.teamC.domain.chat.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class ChatRoomDto {

    @Builder
    public record ChatRoomListResponseDto (
            List<ChatRoomResponseDto> ChatRoomResponseDtoList
    ) {
    }

    @Builder
    public record ChatRoomResponseDto (
            Long chatRoomId,
            LocalDateTime dateTime,
            String region,
            String lastMessage,
            Integer memberCount
    ) {
    }
}
