package com.icaro.service_tasks.client;

import com.icaro.service_tasks.DTO.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
public interface NotificationClient {
    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequest request);
}
