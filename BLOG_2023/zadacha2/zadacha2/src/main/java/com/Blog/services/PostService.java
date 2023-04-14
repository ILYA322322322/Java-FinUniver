package com.Blog.services;

import java.util.List;

import com.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog.models.Post;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Integer id){
        return postRepository.findById(id).get();
    }

    public void save(Post post){
        postRepository.save(post);
    }

    public void delete(Integer id){
        postRepository.deleteById(id);
    }
}
