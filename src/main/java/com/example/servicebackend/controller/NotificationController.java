package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.service.NotificationService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(new ResponseDto("Create notification successfully", newNotification, HttpStatus.CREATED.value()));
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<?> getNotificationById(@PathVariable("notificationId") Long notificationId) {
        NotificationDto notificationDto = notificationService.findNotificationById(notificationId);
        if (notificationDto != null) {
            return ResponseEntity.ok(new ResponseDto("Get notification successfully", notificationDto, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Notification not found", null, HttpStatus.NOT_FOUND.value()));
    }
}
