package com.icaro.service_tasks.DTO;

import java.time.LocalDateTime;

public record TasksRequest(
        String title,
        String email,
        LocalDateTime dueDate,
        Boolean notified
) {
}
