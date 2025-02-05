package com.bocchidev.backtodoweb.services;

import com.bocchidev.backtodoweb.entities.TaskEntity;
import com.bocchidev.backtodoweb.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void putTask(Long id, TaskEntity taskEntity) {
        taskEntity.setId_task(id);
        taskRepository.save(taskEntity);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
