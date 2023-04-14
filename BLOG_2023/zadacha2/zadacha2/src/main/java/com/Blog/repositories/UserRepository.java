package com.Blog.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findByFirstName(String firstName);
}
