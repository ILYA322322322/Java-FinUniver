package com.Blog.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
    List<Post> findByUser(String user);
}
