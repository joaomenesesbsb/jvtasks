package com.jvmeneses.jvtasks.services;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jvmeneses.jvtasks.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jvmeneses.jvtasks.dto.TaskDTO;
import com.jvmeneses.jvtasks.entities.Task;
import com.jvmeneses.jvtasks.entities.User;
import com.jvmeneses.jvtasks.repositories.TaskRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
        TaskDTO taskDTO = new TaskDTO(1L,"Task name", Instant.now(), "Task Description", false, userDTO);

        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());

        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setComplete(false);
        task.setPrompt(Instant.now());
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
    public void testFindAllTasks() {
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task();
        task1.setId(1L);
        task1.setName("Task 1");
        task1.setDescription("Task 1 Description");
        taskList.add(task1);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setName("Task 2");
        task2.setDescription("Task 2 Description");
        taskList.add(task2);

        PageRequest pageRequest = PageRequest.of(0, 2);

        when(repository.findAll(pageRequest)).thenReturn(new PageImpl<>(taskList));

        List<TaskDTO> taskDTOList = taskService.findAll(pageRequest).getContent();

        assertEquals(taskDTOList.size(), taskList.size());
        assertEquals(taskDTOList.get(0).getName(), taskList.get(0).getName());
        assertEquals(taskDTOList.get(0).getDescription(), taskList.get(0).getDescription());
        assertEquals(taskDTOList.get(1).getName(), taskList.get(1).getName());
        assertEquals(taskDTOList.get(1).getDescription(), taskList.get(1).getDescription());
    }

    @Test
    public void testFindTaskById() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setName("Task Name");
        task.setDescription("Task Description");

        when(repository.findById(taskId)).thenReturn(Optional.of(task));

        TaskDTO taskDTO = taskService.findById(taskId);

        assertEquals(taskDTO.getId(), taskId);
        assertEquals(taskDTO.getName(), task.getName());
        assertEquals(taskDTO.getDescription(), task.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Long taskId = 1L;

        taskService.deleteTask(taskId);

        verify(repository, times(1)).deleteById(taskId);
    }
}

