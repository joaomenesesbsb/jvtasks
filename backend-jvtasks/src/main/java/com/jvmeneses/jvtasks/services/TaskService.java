package com.jvmeneses.jvtasks.services;

import com.jvmeneses.jvtasks.dto.TaskDTO;
import com.jvmeneses.jvtasks.entities.Task;
import com.jvmeneses.jvtasks.entities.User;
import com.jvmeneses.jvtasks.exeptions.DatabaseExeption;
import com.jvmeneses.jvtasks.exeptions.ResourceNotFoundExeption;
import com.jvmeneses.jvtasks.repositories.TaskRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Transactional
    public TaskDTO insert(TaskDTO dto) {

        Task entity = new Task();

        entity = copyDtoToEntity(dto, entity);

        entity.setComplete(false);
        entity.setPrompt(Instant.now());

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
        Task task = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption("Recurso não encontrado")
        );
        return new TaskDTO(task);
    }

    @Transactional
    public TaskDTO uptade(Long id, TaskDTO dto) {
        try {
            Task entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return  new TaskDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeption("Recurso não encontrado");
        }

    }

    @Transactional
    public void deleteTask(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundExeption("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseExeption("Falha de integridade referencial");
        }
    }

    private Task copyDtoToEntity(TaskDTO dto, Task entity){

        User user = new User();

        user.setName(dto.getCreator().getName());
        user.setId(dto.getCreator().getId());
        user.setEmail(dto.getCreator().getEmail());

        entity.setName(dto.getName());
        entity.setComplete(dto.getComplete());
        entity.setPrompt(dto.getPrompt());
        entity.setDescription(dto.getDescription());
        entity.setCreator(user);

        return entity;
    }


}
