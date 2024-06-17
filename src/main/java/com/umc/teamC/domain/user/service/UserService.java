package com.umc.teamC.domain.user.service;


import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.dto.UserRequestDTO;

public interface UserService {
    User createUser(UserRequestDTO.JoinDTO joinDTO);

    //User readUser(Long userId);

    //void deleteUser(Long userId);

    //List<User> readUsers();

    //User updateUser(UserRequestDTO.UpdateUserDTO updateUserDTO, Long userId);

}
