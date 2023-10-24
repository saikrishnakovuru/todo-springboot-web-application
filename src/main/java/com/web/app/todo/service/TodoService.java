package com.web.app.todo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        new Todo(++id, "sai", "Full Stack Java Development", formatLocalDateToMMyyYyyy(LocalDate.now().plusYears(1)),
            false),
        new Todo(++id, "Uj", "DevOps", formatLocalDateToMMyyYyyy(LocalDate.now().plusYears(1)), false),
        new Todo(++id, "Manda", "Testing", formatLocalDateToMMyyYyyy(LocalDate.now().plusYears(1)), false),
        new Todo(++id, "Panda", "React", formatLocalDateToMMyyYyyy(LocalDate.now().plusYears(1)), false)));
  }

  private LocalDate formatLocalDateToMMyyYyyy(LocalDate localDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String formattedDate = localDate.format(formatter);
    return LocalDate.parse(formattedDate, formatter);
  }

  public List<Todo> getListOfTodos() {
    return listOfTodos;
  }

  public void addNewTodo(String userName, String description, LocalDate date, boolean value) {
    listOfTodos.add(new Todo(++id, userName, description, date, value));
  }

  public void deleteTodoById(int id) {
    listOfTodos.removeIf(todo -> todo.getId() == id);
  }

  public Todo getTodoById(int id) {
    return listOfTodos.stream().filter(todo -> todo.getId() == id).findFirst().get();
  }
}
