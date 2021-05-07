package com.example.todoapi.repository;

import com.example.todoapi.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query("select t from Todo t where t.title like  %?1% or t.detail like %?1%")
    public Page<Todo> search(String keyword , Pageable pageable);

    public Page<Todo> findAll(Pageable pageable);
}
