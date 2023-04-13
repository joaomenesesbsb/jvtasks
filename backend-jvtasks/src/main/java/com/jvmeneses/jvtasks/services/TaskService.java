package com.jvmeneses.jvtasks.services;

import com.jvmeneses.jvtasks.dto.TaskDTO;
import com.jvmeneses.jvtasks.entities.Task;
import com.jvmeneses.jvtasks.entities.User;
import com.jvmeneses.jvtasks.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.time.Instant;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Transactional
    public TaskDTO insert(TaskDTO dto) {
        Task entity = new Task();
        User user = new User();
        entity.setName(dto.getName());
        entity.setComplete(false);
        entity.setPrompt(Instant.now());
        entity.setDescription(dto.getDescription());
        user.setName(dto.getCreator().getName());
        user.setId(dto.getCreator().getId());
        user.setEmail(dto.getCreator().getEmail());
        entity.setCreator(user);
        entity = repository.save(entity);
        return new TaskDTO(entity);
    }

    @Transactional
    public Page<TaskDTO> findAll(Pageable pageable){
        Page<Task> result = repository.findAll(pageable);
        System.out.println(result);
        return result.map(x -> new TaskDTO(x));
    }

    @Transactional
    public TaskDTO findById(Long id){
        Task task = repository.findById(id).orElseThrow();
        return new TaskDTO(task);
    }

    @Transactional
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
