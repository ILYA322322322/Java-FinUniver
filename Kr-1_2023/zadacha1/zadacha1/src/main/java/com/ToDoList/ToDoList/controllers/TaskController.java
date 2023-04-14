package com.ToDoList.ToDoList.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.ToDoList.models.Task;
import com.ToDoList.ToDoList.services.UserService;
import com.ToDoList.ToDoList.services.TaskService;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
        try{
            Task task = taskService.getTaskById(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
}
