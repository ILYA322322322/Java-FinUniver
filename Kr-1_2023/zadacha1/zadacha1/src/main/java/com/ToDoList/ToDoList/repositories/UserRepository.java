package com.ToDoList.ToDoList.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoList.ToDoList.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findByFirstName(String firstName);
}
