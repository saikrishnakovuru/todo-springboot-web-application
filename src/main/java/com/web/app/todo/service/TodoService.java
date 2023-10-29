package com.web.app.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.web.app.todo.pojo.Todo;

@Controller
public class TodoService {

  private List<Todo> todosList;
  private int id;

  public TodoService() {
    todosList = new ArrayList<>();
    id = 0;
    addTodosToTheList();
  }

  private void addTodosToTheList() {
    // todosList.addAll(Arrays.asList(new Todo(++id, "sai", "Full stack",
    // LocalDate.now().plusYears(1), false),
    // new Todo(++id, "Uj", "DevOps", LocalDate.now().plusYears(1), false),
    // new Todo(++id, "Pb", "Angular", LocalDate.now().plusYears(2), false),
    // new Todo(++id, "Manda", "Testing", LocalDate.now().plusYears(1), false),
    // new Todo(++id, "sastri", "IS-IT", LocalDate.now().plusYears(2), false)));
  }

  public List<Todo> getAllTodos() {
    return todosList;
  }

  public List<Todo> findByUserName(String userName) {
    return todosList.stream().filter(todo -> todo.getUserName().equalsIgnoreCase(userName)).toList();
  }

  public void deleteTodo(int id) {
    todosList.removeIf(todo -> todo.getId() == id);
  }

  public Todo getTodoById(int id) {
    return todosList.stream().filter(todo -> todo.getId() == id).findFirst().get();
  }

  public void saveNewTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
    todosList.add(new Todo(++id, userName, description, targetDate, isDone));
  }

  public void updateTodo(int id, Todo todo) {
    Todo currenTodo = getTodoById(id);
    currenTodo.setDone(todo.getTargetDate().isBefore(LocalDate.now()));
    currenTodo.setDescription(todo.getDescription());
    currenTodo.setTargetDate(todo.getTargetDate());
  }

}
