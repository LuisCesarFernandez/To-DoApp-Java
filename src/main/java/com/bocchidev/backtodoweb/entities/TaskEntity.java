package com.bocchidev.backtodoweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    private LocalDate creation_date;

    @Column(name = "expiration_date")
    private LocalDate expiration_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_state")
    private EState task_state = EState.ACTIVO;

    @PrePersist
    private void assignCreationDate() {
        this.creation_date = LocalDate.now();
    }

    public TaskEntity() {}

    public TaskEntity(String task_name,
                      Long id_task,
                      String task_description,
                      LocalDate creation_date,
                      LocalDate expiration_date,
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

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public EState getTask_state() {
        return task_state;
    }

    public void setTask_state(EState task_state) {
        this.task_state = task_state;
    }
}
