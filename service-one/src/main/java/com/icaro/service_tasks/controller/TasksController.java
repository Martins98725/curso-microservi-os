package com.icaro.service_tasks.controller;

import com.icaro.service_tasks.DTO.TasksRequest;
import com.icaro.service_tasks.model.Tasks;
import com.icaro.service_tasks.repository.TasksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksRepository tasksRepository;

    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody TasksRequest task) {
        Tasks taskEntity = new Tasks(task);

        taskEntity = tasksRepository.save(taskEntity);

        return ResponseEntity.ok(taskEntity);
    }

}
