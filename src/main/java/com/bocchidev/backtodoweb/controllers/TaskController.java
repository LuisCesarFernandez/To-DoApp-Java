package com.bocchidev.backtodoweb.controllers;

import com.bocchidev.backtodoweb.entities.EState;
import com.bocchidev.backtodoweb.entities.TaskEntity;
import com.bocchidev.backtodoweb.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @GetMapping(path = "/")
    public List<TaskEntity> listAllTask() {
        return taskService.getAllTask();
    }

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @GetMapping(path = "/{id}")
    public Optional<TaskEntity> listIdTask(@PathVariable Long id) {
        return taskService.getIdTask(id);
    }

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @PostMapping(path = "/")
    public String createTask(@RequestBody TaskEntity taskEntity){
        taskService.postTask(taskEntity);
        return "Task Created";
    }

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @PatchMapping(path = "/{id}")
    public ResponseEntity<TaskEntity> updateOneElement(@PathVariable Long id, @RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    public record TaskUpdateRequest (String task_name, String task_description, LocalDateTime expiration_date, EState task_state) {}

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @DeleteMapping(path = "/{id}")
    public void removeTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
