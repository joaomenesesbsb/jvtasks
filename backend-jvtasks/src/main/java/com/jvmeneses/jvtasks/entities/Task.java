package com.jvmeneses.jvtasks.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant prompt;
    private String description;
    private Boolean complete;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    public Task(){

    }

    public Task(Long id, String name, Instant prompt, String description, Boolean complete, User creator) {
        this.id = id;
        this.name = name;
        this.prompt = prompt;
        this.description = description;
        this.complete = complete;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getPrompt() {
        return prompt;
    }

    public void setPrompt(Instant prompt) {
        this.prompt = prompt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prompt=" + prompt +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", creator=" + creator +
                '}';
    }
}
