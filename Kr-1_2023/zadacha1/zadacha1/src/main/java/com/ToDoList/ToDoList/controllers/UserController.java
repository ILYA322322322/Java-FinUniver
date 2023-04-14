package com.ToDoList.ToDoList.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.ToDoList.models.User;
import com.ToDoList.ToDoList.models.Task;
import com.ToDoList.ToDoList.services.UserService;
import com.ToDoList.ToDoList.services.TaskService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @PostMapping("/{id}/task/")
    public void addTask(@PathVariable Integer id, @RequestBody Task task){
        User user = userService.getUserById(id);
        task.setUser(String.valueOf(user));
        taskService.save(task);
    }


    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){
        try{
            User user = userService.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.getUserByFirstName(name);
    }

    @PostMapping("/")
    public void add(@RequestBody User user){
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
        try{
            User baseUser = userService.getUserById(id);
            baseUser.updateClient(user);
            userService.saveUser(baseUser);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
