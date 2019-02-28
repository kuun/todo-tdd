package org.tdd.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tdd.pojo.Todo;

import java.util.List;

public class TodoServiceImplTest {
    private Todo buyDogFood;
    private Todo buyCatFood;
    private TodoServiceImpl todoService;

    @Before
    public void setup() {
        todoService = new TodoServiceImpl();
        buyDogFood = new Todo("Buy dog food");
        buyCatFood = new Todo("Buy cat food");

        todoService.addTodo(buyDogFood);
        todoService.addTodo(buyCatFood);
    }

    @Test
    public void add2TodoTest() {
        Assert.assertEquals("todo list length should be 2", 2, todoService.todos.size());
        Assert.assertTrue("todo 'Buy dog food' should be in todo list", todoService.todos.contains(buyDogFood));
        Assert.assertTrue("todo 'Buy cat food' should be in todo list", todoService.todos.contains(buyCatFood));
    }

    @Test
    public void deleteTodo() {
        todoService.deleteTodo(buyDogFood);
        Assert.assertTrue("todo 'Buy dog food' should not be in todo list", !todoService.todos.contains(buyDogFood));
        todoService.deleteTodo(buyCatFood);
        Assert.assertTrue("todo 'Buy cat food' should not be in todo list", !todoService.todos.contains(buyCatFood));
        Assert.assertTrue("todo list should be empty", todoService.todos.isEmpty());
    }

    @Test
    public void getAllTodos() {
        List<Todo> todos = todoService.getTodos();
        Assert.assertEquals("todo list length should be 2", 2, todos.size());
        Assert.assertTrue("todo 'Buy dog food' should be in todo list", todos.contains(buyDogFood));
        Assert.assertTrue("todo 'Buy cat food' should be in todo list", todos.contains(buyCatFood));
    }
}
