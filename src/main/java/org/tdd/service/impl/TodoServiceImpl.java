package org.tdd.service.impl;

import org.tdd.pojo.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoServiceImpl {
    AtomicInteger nextId = new AtomicInteger();
    List<Todo> todos;

    public TodoServiceImpl() {
        this.todos = new ArrayList<>();
    }

    public Todo addTodo(Todo todo) {
        todo.setId(nextId.getAndAdd(1));
        todos.add(todo);
        return todo;
    }

    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void deleteTodoById(int todoId) {
        todos.removeIf(todo -> todo.getId() == todoId);
    }
}
