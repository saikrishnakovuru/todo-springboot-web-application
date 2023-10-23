package com.web.app.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.app.todo.service.TodoService;

@Controller
@SessionAttributes("n")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String listOutAllTodos(ModelMap model) {
        model.addAttribute("todosList", service.getListOfTodos());
        return "/views/listTodos";
    }
}
