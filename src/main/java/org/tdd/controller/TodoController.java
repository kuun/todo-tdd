package org.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tdd.pojo.Todo;
import org.tdd.service.ITodoService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TodoController {
    ITodoService todoService;

    @Autowired
    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/todo")
    public Todo addTodo(@RequestBody Todo todo, HttpServletResponse response) {
        Todo result = todoService.addTodo(todo);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return result;
    }
}
