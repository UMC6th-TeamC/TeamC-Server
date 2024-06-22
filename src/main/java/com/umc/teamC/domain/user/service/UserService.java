package com.umc.teamC.domain.user.service;


import com.umc.teamC.domain.user.dto.UpdateUserDTO;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String getUser(String username) {
        User user = userRepository.findByUsername(username);
        return user.getNickname();
    }

    public User updateUser(UpdateUserDTO updateUserDTO, String username) {
        User user = userRepository.findByUsername(username);
        user.update(updateUserDTO.getNickname());
        return user;
    }
}
