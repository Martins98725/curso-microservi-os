package com.icaro.service_notification.controller;

import com.icaro.service_notification.DTO.NotificationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest request) {
        // Lógica para enviar notificación
        System.out.println(" mensagem: " + request.message());
        return ResponseEntity.ok().build();
    }
}
