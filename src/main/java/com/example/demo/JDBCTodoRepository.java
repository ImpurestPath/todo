package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCTodoRepository implements ITodoRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<TodoItem> getAll() {
        List<TodoItem> query = jdbcTemplate.query(
                "SELECT name, description, done FROM todo",
                (rs, rowNum) -> new TodoItem(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBoolean("done"))
        );
        return query;
    }

    @Override
    public TodoItem get(String nameTodoItem) {
        return null;
    }

    @Override
    public void add(TodoItem todoitem) {

    }

    @Override
    public void update(TodoItem todoitem) {

    }

    @Override
    public void delete(String nameTodoItem) {

    }
}
