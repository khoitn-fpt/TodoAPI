package com.example.todoapi.api;

import com.example.todoapi.entity.Todo;
import com.example.todoapi.repository.TodoRepository;
import com.example.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    TodoService todoService;
    @Autowired
    TodoRepository todoRepository;
    public static final int PAGE_SIZE = 3;

    @GetMapping("/todos")
    public ResponseEntity<?> getAllTodo(Pageable pageable) {
        Page<Todo> todos = todoService.findAll(pageable);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Todo todos = todoService.findById(id);
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/todos")
    public ResponseEntity<?> create(@RequestBody Todo todo) {
        //valid du lieu
        Todo t = todoService.save(todo);

        return ResponseEntity.ok(t);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo, @PathVariable(name = "id") Long id) {
        Todo t = todoService.findById(id);
        if (t != null) {
            todo.setId(id);
            todoService.save(todo);
        }
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "id") Long id) {
        Todo todo = todoService.delete(id);
        return ResponseEntity.ok(todo);
    }
}
