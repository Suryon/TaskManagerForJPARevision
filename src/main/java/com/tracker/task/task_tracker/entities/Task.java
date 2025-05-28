package com.tracker.task.task_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="jpa_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(LocalDateTime completed_at) {
        this.completed_at = completed_at;
    }

    @Column(name="task_title", length = 100, nullable = false)
    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus=TaskStatus.PENDING;

    private LocalDateTime created_at=LocalDateTime.now();

    private LocalDateTime completed_at;


}
