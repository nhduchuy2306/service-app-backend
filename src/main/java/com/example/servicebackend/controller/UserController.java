package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.GoogleUserInfoDto;
import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.UserDto;
import com.example.servicebackend.service.NotificationService;
import com.example.servicebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto != null) {
            return ResponseEntity.ok(new ResponseDto("Get user successfully", userDto, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("User not found", null, HttpStatus.NOT_FOUND.value()));
    }

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        UserDto res = userService.addUser(userDto);
        return ResponseEntity.created(null).body(new ResponseDto("Add user successfully", res, HttpStatus.CREATED.value()));
    }

    @PostMapping("/auth/google")
    public ResponseEntity<?> addGoogleUserInfor(@RequestBody GoogleUserInfoDto googleUserInfoDto) {
        UserDto userDto = userService.getUserById(googleUserInfoDto.getUid());
        if (userDto != null) {
            return ResponseEntity.ok(new ResponseDto("User already exists", userDto, HttpStatus.OK.value()));
        } else {
            UserDto res = userService.addGoogleUserInfor(googleUserInfoDto);
            return ResponseEntity.created(null).body(new ResponseDto("Add user successfully", res, HttpStatus.CREATED.value()));
        }
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByUserId(@PathVariable("id") String userId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByUserId(userId);
        return ResponseEntity.ok(new ResponseDto("Get all notifications successfully", notificationDtos, HttpStatus.OK.value()));
    }

}
