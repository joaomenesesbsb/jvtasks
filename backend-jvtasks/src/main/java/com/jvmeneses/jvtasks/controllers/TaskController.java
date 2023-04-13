package com.jvmeneses.jvtasks.controllers;

import com.jvmeneses.jvtasks.dto.TaskDTO;
import com.jvmeneses.jvtasks.entities.Task;
import com.jvmeneses.jvtasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService service;
    @PostMapping
    public TaskDTO insert(@RequestBody TaskDTO dto) {
        dto = service.insert(dto);
        return dto;
    }
    @GetMapping
    public Page<TaskDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        TaskDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping
    public  void deleteTask(Long id){
        service.deleteTask(id);
    }
}
