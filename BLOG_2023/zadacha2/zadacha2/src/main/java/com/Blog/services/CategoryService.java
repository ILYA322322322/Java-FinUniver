package com.Blog.services;

import java.util.List;

import com.Blog.models.Category;
import com.Blog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
