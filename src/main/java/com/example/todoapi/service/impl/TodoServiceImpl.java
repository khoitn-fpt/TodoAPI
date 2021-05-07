package com.example.todoapi.service.impl;

import com.example.todoapi.entity.Todo;
import com.example.todoapi.repository.TodoRepository;
import com.example.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Page<Todo> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }


    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo delete(Long id) {
        Todo todo = todoRepository.findById(id).get();
        todoRepository.delete(todo);
        return todo;
    }
}
