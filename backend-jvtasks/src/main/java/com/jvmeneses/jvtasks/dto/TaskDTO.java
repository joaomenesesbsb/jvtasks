package com.jvmeneses.jvtasks.dto;

import com.jvmeneses.jvtasks.entities.Task;

import java.time.Instant;

public class TaskDTO {
    private Long id;
    private String name;
    private Instant start;
    private Instant prompt;
    private String description;
    private Boolean complete;
    private UserDTO creator;

    public TaskDTO(){
    }

    public TaskDTO(Long id, String name,Instant start, Instant prompt, String description, Boolean complete, UserDTO creator) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.prompt = prompt;
        this.description = description;
        this.complete = complete;
        this.creator = creator;
    }

    public TaskDTO(Task entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.start = entity.getStart();
        this.prompt = entity.getPrompt();
        this.description = entity.getDescription();
        this.complete = entity.getComplete();
        this.creator = new UserDTO(entity.getCreator());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getStart() {
        return start;
    }

    public Instant getPrompt() {
        return prompt;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public UserDTO getCreator() {
        return creator;
    }
}
