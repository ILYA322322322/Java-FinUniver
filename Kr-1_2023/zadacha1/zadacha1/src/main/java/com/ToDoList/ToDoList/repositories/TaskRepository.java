package com.ToDoList.ToDoList.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoList.ToDoList.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    List<Task> findByUser(String user);
}
