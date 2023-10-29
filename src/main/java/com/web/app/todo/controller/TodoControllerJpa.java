package com.web.app.todo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.app.todo.pojo.Todo;
import com.web.app.todo.repository.TodoRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoRepository repository;

    public TodoControllerJpa(TodoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTheTodosList(ModelMap model) {
        String userName = getLoggedInUserName(model);
        List<Todo> todos = repository.findByUserName(userName);
        model.addAttribute("listOfTodos", todos);
        return "listTodos";
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
        todo.setUserName(userName);
        todo.setDone(todo.getTargetDate().isBefore(LocalDate.now()));
        repository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        repository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        Todo todo = repository.findById(id).get();
        model.addAttribute("todo", todo);
        model.addAttribute("buttonName", "Update");
        return "addNewTodo";
    }

    @PostMapping("/update-todo")
    public String saveUpdatedTodoAndDisplayListTodosPage(ModelMap model, @Valid Todo todo, BindingResult result,
            @RequestParam int id) {
        if (result.hasErrors())
            return "addNewTodo";

        todo.setUserName(getLoggedInUserName(model));
        todo.setDone(todo.getTargetDate().isBefore(LocalDate.now()));
        repository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
