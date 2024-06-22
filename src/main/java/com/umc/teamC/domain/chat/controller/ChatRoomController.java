package com.umc.teamC.domain.chat.controller;

import com.umc.teamC.domain.chat.dto.ChatRoomDto;
import com.umc.teamC.domain.chat.service.RestChatService;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("*")
@RequestMapping("/chat-group")
public class ChatRoomController {

    private final RestChatService restChatService;

    // 채팅방 목록 조회 - 채팅방 지역, 시간, 마지막 메세지 전달
    @GetMapping("")
    public BaseResponse<List<ChatRoomDto.ChatRoomResponseDto>> getChatRoomList(
            @AuthenticationPrincipal User user
            ) {
        List<ChatRoomDto.ChatRoomResponseDto> chatRoomListResponseDto =
                restChatService.getChatRoomList(user);
        return BaseResponse.onSuccess(chatRoomListResponseDto);
    }

}
