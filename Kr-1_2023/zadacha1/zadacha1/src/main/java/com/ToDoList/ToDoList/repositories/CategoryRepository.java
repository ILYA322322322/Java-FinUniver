package com.ToDoList.ToDoList.repositories;
import com.ToDoList.ToDoList.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

