package com.web.app.todo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.app.todo.pojo.Todo;
import com.web.app.todo.service.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("n")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listOutAllTodos(ModelMap model) {
        model.addAttribute("todosList", service.getListOfTodos());
        return "/views/listTodos";
    }

    @RequestMapping(value = "/add-new-todo", method = RequestMethod.GET)
    public String goToAddNewTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "/views/addNewTodo";
    }

    @RequestMapping(value = "/add-new-todo", method = RequestMethod.POST)
    public String displayNewlyAddedTodoInTheListOfTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (!result.hasErrors()) {
            boolean isDone = LocalDate.now().isAfter(todo.getTargetDate());
            service.addNewTodo((String) model.get("n"), todo.getDescription(), todo.getTargetDate(), isDone);
            return "redirect:/list-todos";
        }
        return "/views/addNewTodo";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodoPage(ModelMap model, @RequestParam int id) {
        model.addAttribute("todo", service.getTodoById(id));
        System.out.println(service.getTodoById(id));
        return "/views/addNewTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String saveTheUpdatedTodoAndRedirectToListTodoPage(@Valid Todo todo, BindingResult result,
            @RequestParam int id) {

        if (result.hasErrors())
            return "/views/addNewTodo";

        Todo prevTodo = service.getTodoById(id);
        prevTodo.setDescription(todo.getDescription());
        prevTodo.setTargetDate(todo.getTargetDate());
        return "redirect:list-todos";
    }

}
