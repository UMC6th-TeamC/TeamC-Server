package com.umc.teamC.domain.user.entity;

import com.umc.teamC.domain.chat.entity.ChatRoomUser;
import com.umc.teamC.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nickname;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<ChatRoomUser> chatRoomUserList = new ArrayList<>();

    public void update(String nickname) {
        this.nickname = nickname;
    }
}
