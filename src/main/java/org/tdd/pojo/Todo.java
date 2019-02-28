package org.tdd.pojo;

public class Todo {
    private String title;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return title.equals(todo.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                '}';
    }
}
