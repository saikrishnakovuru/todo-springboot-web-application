package com.web.app.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.app.todo.pojo.Todo;

@Service
public class TodoService {

    private List<Todo> listOfTodos;
    private int id;

    public TodoService() {
        listOfTodos = new ArrayList<>();
        id = 0;
        addSomeTodos();
    }

    private void addSomeTodos() {
        listOfTodos.addAll(Arrays.asList(
                new Todo(++id, "sai", "Full Stack Java Development", LocalDate.now().plusYears(1), false),
                new Todo(++id, "Uj", "DevOps", LocalDate.now().plusYears(2), false),
                new Todo(++id, "Manda", "Resting", LocalDate.now().plusYears(1), false),
                new Todo(++id, "Panda", "React", LocalDate.now().plusYears(1), false)));
    }

    public List<Todo> getListOfTodos() {
        return listOfTodos;
    }

    public void addNewTodo(String userName, String description, LocalDate date, boolean value) {
        listOfTodos.add(new Todo(++id, userName, description, date, value));
    }
}
