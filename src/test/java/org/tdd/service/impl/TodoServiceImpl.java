package org.tdd.service.impl;

import org.junit.Test;
import org.tdd.pojo.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl {
    List<Todo> todos;

    public TodoServiceImpl() {
        this.todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
