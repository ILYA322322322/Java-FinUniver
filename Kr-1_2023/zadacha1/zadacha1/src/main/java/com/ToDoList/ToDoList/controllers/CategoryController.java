package com.ToDoList.ToDoList.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.ToDoList.ToDoList.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.ToDoList.models.Task;
import com.ToDoList.ToDoList.services.CategoryService;
import com.ToDoList.ToDoList.services.TaskService;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        try{
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
