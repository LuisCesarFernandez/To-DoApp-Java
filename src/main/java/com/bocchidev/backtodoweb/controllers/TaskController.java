package com.bocchidev.backtodoweb.controllers;

import com.bocchidev.backtodoweb.entities.TaskEntity;
import com.bocchidev.backtodoweb.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping(path = "/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody TaskEntity taskEntity){
        taskService.putTask(id, taskEntity);
        return "Task updated";
    }

    @CrossOrigin(originPatterns = "http://localhost:5173/")
    @DeleteMapping(path = "/{id}")
    public void removeTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
