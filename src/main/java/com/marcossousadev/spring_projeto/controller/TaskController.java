package com.marcossousadev.spring_projeto.controller;

import com.marcossousadev.spring_projeto.domain.Task;
import com.marcossousadev.spring_projeto.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/buscar-task/{id}")
    public Task getTask(@PathVariable("id") int id){
        return taskService.getTask(id);
    }

    @PostMapping("/criar-task")
    public String postTask(@RequestBody Task task){
        return taskService.postTask(task);
    }

    @GetMapping("/buscar-tarefas")
    public List<Task> getTasks(@RequestParam(value = "filter", required = false) String filter){
        return taskService.getTasks(filter);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id){
        return taskService.deleteTask(id);
    }

    @PatchMapping("/update-status/{id}")
    public String uptadeTask(@PathVariable("id") int id) {
        return taskService.updateStatusTask(id);
    }
    @PatchMapping("/update-task/{id}")
    public String updateDataTask(@PathVariable("id") int id, @RequestBody Task body){
        return taskService.updateDataTask(id, body);
    }
}
