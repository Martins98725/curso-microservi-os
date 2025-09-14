package com.icaro.service_tasks.service;

import com.icaro.service_tasks.DTO.NotificationRequest;
import com.icaro.service_tasks.client.NotificationClient;
import com.icaro.service_tasks.model.Tasks;
import com.icaro.service_tasks.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TasksRepository taskRepository;
    private final NotificationClient notificationClient;

    public TaskService(TasksRepository taskRepository, NotificationClient notificationClient) {
        this.taskRepository = taskRepository;
        this.notificationClient = notificationClient;
    }


    public void sendNotificationForDueTasks(){
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<Tasks> tasks = taskRepository.findTasksDueWithinDeadLine(deadline);

        for(Tasks task: tasks){
            NotificationRequest request = new NotificationRequest(task.getEmail(), "Sua tarefa está para vencer: " + task.getTitle());
            notificationClient.sendNotification(request);
            task.setNotified(true);

            taskRepository.save(task);
        }
    }
}
