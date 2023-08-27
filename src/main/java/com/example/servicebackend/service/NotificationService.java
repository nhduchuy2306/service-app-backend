package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto addNotification(NotificationDto notificationDto);
    List<NotificationDto> getAllNotificationsByUserId(String userId);
    List<NotificationDto> getAllNotificationsByPartnerId(String partnerId);
    NotificationDto findNotificationById(Long notificationId);
}
