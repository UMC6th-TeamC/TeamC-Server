package com.umc.teamC.domain.email.service;

import com.umc.teamC.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final RedisUtil redisUtil;

    @Value("${spring.mail.username}")
    private String senderEmail;

    private String senderName = "LikeLion";

    private String createKey() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(3);

            switch (index) {
                case 0:
                    key.append((char) (rnd.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) (rnd.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(rnd.nextInt(10));
                    break;
            }
        }
        return key.toString();
    }

    private MimeMessage createMessage(String to, String ePw) throws Exception {
        System.out.println("보내는 대상: " + to);
        System.out.println("인증 번호: " + ePw);
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject("이메일 인증 테스트");

        String msgg = "";
        msgg += "<div style='margin:15px;'>";
        msgg += "<h1> LikeLion Email Authentication </h1>";
        msgg += "<br>";
        msgg += "<p>아래 코드를 복사해 입력해주세요<p>";
        msgg += "<br>";
        msgg += "<p>감사합니다.<p>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'>이메일 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE: <strong>";
        msgg += ePw + "</strong><div><br/>";
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");
        message.setFrom(new InternetAddress(senderEmail, senderName));

        return message;
    }

    public String sendSimpleMessage(String to) throws Exception {
        String ePw = createKey();
        MimeMessage message = createMessage(to, ePw);
        try {
            emailSender.send(message);
            redisUtil.save(to, ePw, 5L, TimeUnit.MINUTES);  // 인증번호를 Redis에 저장
            System.out.println("이메일 전송 성공");
        } catch (MailException es) {
            es.printStackTrace();
            System.err.println("이메일 전송 실패");
            throw new IllegalArgumentException("Failed to send email", es);
        }
        return ePw;
    }
}
