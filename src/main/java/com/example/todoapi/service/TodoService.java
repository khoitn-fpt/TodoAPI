package com.example.todoapi.service;

import com.example.todoapi.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {

    public List<Todo> findAll();
    public Page<Todo> findAll(Pageable pageable);
    public Todo findById(Long id);
    public Todo save(Todo todo);
    public Todo delete(Long id);
}
