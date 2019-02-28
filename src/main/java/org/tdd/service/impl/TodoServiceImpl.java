package org.tdd.service.impl;

import org.tdd.pojo.Todo;
import org.tdd.service.ITodoService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoServiceImpl implements ITodoService {
    AtomicInteger nextId = new AtomicInteger();
    List<Todo> todos;

    public TodoServiceImpl() {
        this.todos = new ArrayList<>();
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(nextId.getAndAdd(1));
        todos.add(todo);
        return todo;
    }

    @Override
    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todos;
    }

    @Override
    public void deleteTodoById(int todoId) {
        todos.removeIf(todo -> todo.getId() == todoId);
    }
}
