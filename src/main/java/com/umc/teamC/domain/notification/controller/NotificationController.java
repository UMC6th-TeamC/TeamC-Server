//package com.umc.teamC.domain.notification.controller;
//
//import com.umc.teamC.domain.user.entity.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@RestController
//@RequiredArgsConstructor
//public class NotificationController {
//
//    private final NotificationService notificationService;
//
//    @GetMapping(path = "/api/v1/notifications/stream")
//    public SseEmitter streamNotifications(@AuthenticationPrinciple User user) {
//        return notificationService.createEmitter(user.getId());
//    }
//
//}
