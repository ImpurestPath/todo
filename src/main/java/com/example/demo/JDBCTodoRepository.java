package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class JDBCTodoRepository implements ITodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TodoItem> getAll() {
        List<TodoItem> query = jdbcTemplate.query(
                "SELECT name, description, done FROM todo",
                (rs, rowNum) -> new TodoItem(
                        (UUID) rs.getObject ("id"),
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
                        (UUID) rs.getObject ("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBoolean("done")),
                nameTodoItem
        );
        return query.size() > 0 ? query.get(0) : null;
    }

    @Override
    public void add(String name, String description, Boolean done,TodoItem todoItem) {
        Map<String, TodoItem> todoItemMap = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName("todo")
                .usingColumns("id", "name", "description", "done")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKeyHolder(Map.of( "name",name, "description",
                        description, "done", done))
                .getKeys();
        todoItem = new TodoItem(todoItemMap.get(id));



        //jdbcTemplate.update("INSERT INTO todo (id, name,description, done) values(?,?,?,?)", todoitem.id, todoitem.name, todoitem.description, todoitem.done);
    }

    @Override
    public void update(TodoItem todoitem) {
        /*      jdbcTemplate.update("INSERT INTO todo ((id, name,description, done) values(?,?,?)", todoitem.name,todoitem.description,todoitem.done);
         */
        jdbcTemplate.update("update todo set name = ?, description= ?, done=? where name = ?", todoitem.name, todoitem.description, todoitem.done, todoitem.name);
    }

    @Override
    public void delete(String nameTodoItem) {
        jdbcTemplate.update("delete from todo where name = ?", nameTodoItem);
    }
}
