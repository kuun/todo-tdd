package org.tdd.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.tdd.pojo.Todo;

public class TodoServiceImplTest {
    @Test
    public void add1Todo() {
        String title = "Buy dog food";
        Todo todo = new Todo(title);

        TodoServiceImpl todoService = new TodoServiceImpl();
        todoService.addTodo(todo);
        Assert.assertEquals("todo list length should be 1", 1, todoService.todos.size());
        Todo addedTodo = todoService.todos.get(0);
        Assert.assertEquals("the todo should be '" + title + "'", todo, addedTodo);
    }

}
