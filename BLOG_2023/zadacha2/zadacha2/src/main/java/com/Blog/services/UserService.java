package com.Blog.services;

import java.util.List;

import com.Blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog.models.User;

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
