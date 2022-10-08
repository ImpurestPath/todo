package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCTodoRepository implements ITodoRepository {

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
        List<TodoItem> query = jdbcTemplate.query(
                "SELECT name, description, done FROM todo WHERE name = ?",
                (rs, rowNum) -> new TodoItem(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBoolean("done")),
                nameTodoItem
        );
        return query.size() > 0 ? query.get(0) : null;
    }

    @Override
    public void add(TodoItem todoitem) {
        jdbcTemplate.update("INSERT INTO todo ((id, name,description, done) values(?,?,?)", todoitem.name, todoitem.description, todoitem.done);


    }

    @Override
    public void update(TodoItem todoitem) {
        /*      jdbcTemplate.update("INSERT INTO todo ((id, name,description, done) values(?,?,?)", todoitem.name,todoitem.description,todoitem.done);
         */
        jdbcTemplate.update("update todo set name = todoitem.name, description= todoitem.description, done=todoitem.done where name = todoitem.name");
    }

    @Override
    public void delete(String nameTodoItem) {
        jdbcTemplate.update("delete from todo where name =nameTodoItem");
    }
}
