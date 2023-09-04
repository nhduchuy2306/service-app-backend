package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.service.NotificationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Tag(name = "Notification API")
@SecurityRequirement(name = "Authorization")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("")
    public ResponseEntity<?> addNotification(@RequestBody NotificationDto notificationDto) {
        NotificationDto newNotification = notificationService.addNotification(notificationDto);
        if (newNotification == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(newNotification);
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<?> getNotificationById(@PathVariable("notificationId") Long notificationId) {
        NotificationDto notificationDto = notificationService.findNotificationById(notificationId);
        if (notificationDto != null) {
            return ResponseEntity.ok(notificationDto);
        }
        return ResponseEntity.badRequest().body(null);
    }
}
