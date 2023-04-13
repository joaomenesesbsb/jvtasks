package com.jvmeneses.jvtasks.repositories;

import com.jvmeneses.jvtasks.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
