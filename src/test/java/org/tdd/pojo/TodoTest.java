package org.tdd.pojo;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {
    @Test
    public void testTwoTodoEquals() {
        String title = "Buy dog food";
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();
        todo1.setTitle(title);
        todo2.setTitle(title);

        Assert.assertEquals("todo1 should equal to todo2", todo1, todo2);
    }
}
