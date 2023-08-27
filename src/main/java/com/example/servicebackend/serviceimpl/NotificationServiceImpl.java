package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.model.entity.Notification;
import com.example.servicebackend.model.mapper.NotificationMapper;
import com.example.servicebackend.repository.NotificationRepository;
import com.example.servicebackend.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationDto addNotification(NotificationDto notificationDto) {
        Notification notification = NotificationMapper.INSTANCE.toNotification(notificationDto);
        Notification newNotification = notificationRepository.save(notification);
        if (newNotification != null) {
            return NotificationMapper.INSTANCE.toNotificationDto(newNotification);
        }
        return null;
    }

    @Override
    public List<NotificationDto> getAllNotificationsByUserId(String userId) {
        List<Notification> notifications = notificationRepository.getNotificationsByUserId(userId);
        if (notifications != null) {
            return notifications.stream().map(NotificationMapper.INSTANCE::toNotificationDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<NotificationDto> getAllNotificationsByPartnerId(String partnerId) {
        List<Notification> notifications = notificationRepository.getNotificationsByPartnerId(partnerId);
        if (notifications != null) {
            return notifications.stream().map(NotificationMapper.INSTANCE::toNotificationDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public NotificationDto findNotificationById(Long notificationId) {
        Notification notification = notificationRepository.findAllById(notificationId);
        if (notification != null) {
            return NotificationMapper.INSTANCE.toNotificationDto(notification);
        }
        return null;
    }
}
