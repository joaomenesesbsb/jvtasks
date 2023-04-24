package com.jvmeneses.jvtasks.services;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jvmeneses.jvtasks.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jvmeneses.jvtasks.dto.TaskDTO;
import com.jvmeneses.jvtasks.entities.Task;
import com.jvmeneses.jvtasks.entities.User;
import com.jvmeneses.jvtasks.repositories.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService taskService;


    @Test
    public void testInsertTask() {

        UserDTO userDTO = new UserDTO(1L,"João Victor", "joaovictor@gmail.com");
        TaskDTO taskDTO = new TaskDTO(1L,"Task name", Instant.now(),Instant.parse("2023-07-05T15:00:00Z"), "Task Description", false, userDTO);

        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());

        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setComplete(false);
        task.setStart(Instant.now());
        task.setDescription(taskDTO.getDescription());
        task.setCreator(user);

        when(repository.save(ArgumentMatchers.any(Task.class))).thenReturn(task);

        TaskDTO result = taskService.insert(taskDTO);

        assertEquals(result.getName(), taskDTO.getName());
        assertEquals(result.getDescription(), taskDTO.getDescription());
        assertEquals(result.getCreator().getId(), taskDTO.getCreator().getId());
        assertEquals(result.getComplete(), taskDTO.getComplete());
        assertEquals(result.getCreator().getName(), taskDTO.getCreator().getName());
        assertEquals(result.getCreator().getEmail(), taskDTO.getCreator().getEmail());
    }


    @Test
    public void testDeleteTask() {
        Long taskId = 1L;

        taskService.deleteTask(taskId);

        verify(repository, times(1)).deleteById(taskId);
    }


}

