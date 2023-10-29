package com.web.app.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.todo.pojo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUserName(String userName);

}
