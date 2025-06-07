package com.DriveAuto.adminservice.feign;

import com.DriveAuto.adminservice.model.EmailDetails;
import com.DriveAuto.adminservice.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "notification-service")
public interface NotificationServiceClient {

    @PostMapping("/api/s4/notifications")
    Notification createNotification(@RequestParam Long utilisateurId, @RequestParam String message);
    @PostMapping("/api/s4/notifications/send-email")
    String sendEmail(@RequestBody EmailDetails emailDetails);

    @GetMapping("/api/s4/notifications")
    List<Notification> getAllNotifications();

    @GetMapping("/api/s4/notifications/{id}")
    Notification getNotificationById(@PathVariable Long id);

    @GetMapping("/api/s4/notifications/user/{utilisateurId}")
    List<Notification> getNotificationsByUtilisateurId(@PathVariable Long utilisateurId);

    @DeleteMapping("/api/s4/notifications/{id}")
    void deleteNotification(@PathVariable Long id);
}