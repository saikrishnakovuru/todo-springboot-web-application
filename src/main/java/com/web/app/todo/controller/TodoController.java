package com.web.app.todo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.app.todo.service.TodoService;

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
    public String goToAddNewTodoPage() {
        return "/views/addNewTodo";
    }

    @RequestMapping(value = "/add-new-todo", method = RequestMethod.POST)
    public String displayNewlyAddedTodoInTheListOfTodosPage(ModelMap model, @RequestParam String description,
            @RequestParam LocalDate date) {
        // service.addNewTodo(date, description, null, false);
        boolean isDone = LocalDate.now().isAfter(date) ? true : false;
        service.addNewTodo((String) model.get("n"), description, date, isDone);
        return "redirect:/list-todos";
    }

}
