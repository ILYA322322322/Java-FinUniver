package com.ToDoList.ToDoList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDoList.ToDoList.models.User;
import com.ToDoList.ToDoList.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public User getUserById(Integer id){ return userRepository.findById(id).get();
    }
}
