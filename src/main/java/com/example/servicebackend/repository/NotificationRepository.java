package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.booking.serviceRequest.user.userId = :userId")
    List<Notification> getNotificationsByUserId(String userId);

    @Query("SELECT n FROM Notification n WHERE n.booking.partner.partnerId = :partnerId")
    List<Notification> getNotificationsByPartnerId(String partnerId);

    @Query("SELECT n FROM Notification n WHERE n.notificationId = :notificationId")
    Notification findAllById(Long notificationId);
}
