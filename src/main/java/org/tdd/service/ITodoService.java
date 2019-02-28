package org.tdd.service;

import org.tdd.pojo.Todo;

import java.util.List;

public interface ITodoService {
    Todo addTodo(Todo todo);

    void deleteTodo(Todo todo);

    List<Todo> getTodos();

    void deleteTodoById(int todoId);
}
