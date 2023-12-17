package com.web.app.todo.controller;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.app.todo.pojo.Todo;
import com.web.app.todo.service.TodoService;

import jakarta.validation.Valid;

// commented @COntroller on this class to user TodoControllerJpa
// @Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTheTodosList(ModelMap model) {
        String userName = getLoggedInUserName(model);
        model.addAttribute("listOfTodos", service.findByUserName(userName));
        return "listTodos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:list-todos";
    }

    @GetMapping("add-new-todo")
    public String goToAddNewTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("buttonName", "Add");
        return "addNewTodo";
    }

    @PostMapping("add-new-todo")
    public String saveNewlyAddedTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors())
            return "addNewTodo";
        String userName = getLoggedInUserName(model);
        boolean isDone = todo.getTargetDate().isBefore(LocalDate.now());
        service.saveNewTodo(userName, todo.getDescription(), todo.getTargetDate(), isDone);
        return "redirect:list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        model.addAttribute("todo", service.getTodoById(id));
        model.addAttribute("buttonName", "Update");
        return "addNewTodo";
    }

    @PostMapping("/update-todo")
    public String saveUpdatedTodoAndDisplayListTodosPage(@Valid Todo todo, BindingResult result, @RequestParam int id) {
        if (result.hasErrors())
            return "addNewTodo";

        service.updateTodo(id, todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
