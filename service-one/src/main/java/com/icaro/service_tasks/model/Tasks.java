package com.icaro.service_tasks.model;

import com.icaro.service_tasks.DTO.TasksRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String email;

    private LocalDateTime dueDate;

    private boolean notified;

    public Tasks(TasksRequest tasksRequest) {
        this.title = tasksRequest.title();
        this.email = tasksRequest.email();
        this.dueDate = tasksRequest.dueDate();
        this.notified = tasksRequest.notified();

    }

    public Tasks() {

    }
}
