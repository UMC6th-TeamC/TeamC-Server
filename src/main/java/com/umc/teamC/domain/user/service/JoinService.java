package com.umc.teamC.domain.user.service;

import com.umc.teamC.domain.user.dto.JoinDTO;
import com.umc.teamC.domain.user.entity.User;
import com.umc.teamC.domain.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            return;
        }

        User data = new User();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setNickname(generateRandomNickname());
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);

    }
    public static String generateRandomNickname() {
        List<String> adjectives = Arrays.asList("용감한", "현명한", "재치있는", "호기심 많은", "성실한", "창의적인", "활달한", "차분한", "모험심 있는", "차별화된");
        List<String> nouns = Arrays.asList("호랑이", "독수리", "강아지", "고양이", "토끼", "코끼리", "펭귄", "곰", "올빼미", "사자");

        Random random = new Random();
        String adjective = adjectives.get(random.nextInt(adjectives.size()));
        String noun = nouns.get(random.nextInt(nouns.size()));

        return adjective + noun + (random.nextInt(99) + 1);
    }

}

