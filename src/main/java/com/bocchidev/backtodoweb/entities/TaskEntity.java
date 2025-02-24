package com.bocchidev.backtodoweb.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "task_description")
    private String task_description;

    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creation_date;

    @Column(name = "expiration_date")
    private LocalDateTime expiration_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_state")
    private EState task_state = EState.ACTIVO;

    @PrePersist
    private void assignCreationDate() {
        this.creation_date = LocalDateTime.now(ZoneId.of("America/Bogota"));
    }

    public TaskEntity() {}

    public TaskEntity(String task_name,
                      Long id_task,
                      String task_description,
                      LocalDateTime creation_date,
                      LocalDateTime expiration_date,
                      EState task_state) {
        this.task_name = task_name;
        this.id_task = id_task;
        this.task_description = task_description;
        this.creation_date = creation_date;
        this.expiration_date = expiration_date;
        this.task_state = task_state;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDateTime expiration_date) {
        this.expiration_date = expiration_date;
    }

    public EState getTask_state() {
        return task_state;
    }

    public void setTask_state(EState task_state) {
        this.task_state = task_state;
    }
}
