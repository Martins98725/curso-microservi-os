package com.icaro.service_tasks.DTO;

public record NotificationRequest(
        String email,
        String message
) {
}
