package com.icaro.service_tasks.repository;

import com.icaro.service_tasks.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    @Query("SELECT t FROM Tasks t where t.dueDate <= :deadline and t.notified=false")
    List<Tasks> findTasksDueWithinDeadLine(LocalDateTime deadline);


}
