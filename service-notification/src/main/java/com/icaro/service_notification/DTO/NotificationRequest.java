package com.icaro.service_notification.DTO;

public record NotificationRequest(
        String email,
        String message
) {
}
