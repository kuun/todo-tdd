package org.tdd.pojo;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {
    @Test
    public void todoEqualsIfIdEquals() {
        Todo todo1 = new Todo("Meeting1");
        todo1.setId(1);
        Todo todo2 = new Todo("Meeting2");
        todo2.setId(1);

        Assert.assertEquals("todo should equal if id is the same", todo1, todo2);
    }

    @Test
    public void todoNotEqualsIfIdNotEquals() {
        Todo todo1 = new Todo("Meeting");
        todo1.setId(1);
        Todo todo2 = new Todo("Meeting");
        todo2.setId(2);

        Assert.assertNotEquals("todo should equal if id is the same", todo1, todo2);
    }
}
