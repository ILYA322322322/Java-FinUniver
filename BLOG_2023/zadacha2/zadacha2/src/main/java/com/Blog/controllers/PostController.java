package com.Blog.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.Blog.services.PostService;
import com.Blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.models.Post;


@RestController
@RequestMapping("/task")
public class PostController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id){
        try{
            Post post = postService.getPostById(id);
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    
}
