package com.icaro.service_tasks.scheduling;

import com.icaro.service_tasks.service.TaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksNotificationSchedule {
    private final TaskService taskService;

    public TasksNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 60) // Executa a cada 60 minutos
    public void checkAndNotifyTasks() {

        // Lógica para verificar tarefas pendentes e enviar notificações
        System.out.println("Verificando tarefas pendentes e enviando notificações...");
        // Aqui você pode chamar um serviço que verifica as tarefas e envia notificaçõe
        this.taskService.sendNotificationForDueTasks();
    }
}
