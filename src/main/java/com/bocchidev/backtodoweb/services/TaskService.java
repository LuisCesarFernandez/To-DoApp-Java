package com.bocchidev.backtodoweb.services;

import com.bocchidev.backtodoweb.controllers.TaskController;
import com.bocchidev.backtodoweb.entities.EState;
import com.bocchidev.backtodoweb.entities.TaskEntity;
import com.bocchidev.backtodoweb.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getIdTask(Long id) {
        return taskRepository.findById(id);
    }

    public void postTask(TaskEntity taskEntity){
        taskRepository.save(taskEntity);
    }

    public TaskEntity updateTask(Long id, TaskController.TaskUpdateRequest updates) {
        return taskRepository.findById(id).map(task -> {
            if(updates.task_name() != null) {
                task.setTask_name(updates.task_name());
            }
            if(updates.task_description() != null){
                task.setTask_description(updates.task_description());
            }
            if(updates.expiration_date() != null){
                task.setExpiration_date(updates.expiration_date());
            }
            if(updates.task_state() != null){
                task.setTask_state(updates.task_state());
            }

            return taskRepository.save(task);
        }).orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Scheduled(fixedRate = 10000)
    public void updateTaskState() {
        List<TaskEntity> tasks = taskRepository.findAll();

        for(TaskEntity task : tasks) {
            if(task.getExpiration_date() != null && task.getExpiration_date().isBefore(LocalDateTime.now()))
            {
                task.setTask_state(EState.EXPIRADO);
                taskRepository.save(task);
            }
        }
    }
}
