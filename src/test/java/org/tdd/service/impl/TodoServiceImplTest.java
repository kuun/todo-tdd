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

    @Test
    public void add2TodoTest() {
        Todo buyDogFood = new Todo("Buy dog food");
        Todo buyCatFood = new Todo("Buy cat food");

        TodoServiceImpl todoService = new TodoServiceImpl();
        todoService.addTodo(buyDogFood);
        todoService.addTodo(buyCatFood);

        Assert.assertEquals("todo list length should be 2", 2, todoService.todos.size());
        Assert.assertTrue("todo 'Buy dog food' should be in todo list", todoService.todos.contains(buyDogFood));
        Assert.assertTrue("todo 'Buy cat food' should be in todo list", todoService.todos.contains(buyCatFood));
    }

    @Test
    public void deleteTodo() {
        Todo buyDogFood = new Todo("Buy dog food");
        Todo buyCatFood = new Todo("Buy cat food");

        TodoServiceImpl todoService = new TodoServiceImpl();
        todoService.addTodo(buyDogFood);
        todoService.addTodo(buyCatFood);

        todoService.deleteTodo(buyDogFood);
        Assert.assertTrue("todo 'Buy dog food' should not be in todo list", !todoService.todos.contains(buyDogFood));
        todoService.deleteTodo(buyCatFood);
        Assert.assertTrue("todo 'Buy cat food' should not be in todo list", !todoService.todos.contains(buyCatFood));
        Assert.assertTrue("todo list should be empty", todoService.todos.isEmpty());
    }
}
