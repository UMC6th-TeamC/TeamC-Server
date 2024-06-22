package com.umc.teamC.domain.chat.entity;

import com.umc.teamC.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private LocalDateTime dateTime;
    private String region;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatRoomUser> chatRoomUserList = new ArrayList<>();

    @OneToMany(mappedBy = "chatRoom")
    private List<Chat> chatList = new ArrayList<>();
}
