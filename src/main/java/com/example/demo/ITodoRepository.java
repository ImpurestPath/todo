package com.example.demo;

import java.util.List;

public interface ITodoRepository {

    List<TodoItem> getAll();


   TodoItem get(String nameTodoItem); //возвращает один todoitem по имени
   void  add(TodoItem todoitem); //добавляет итем
   void update(TodoItem todoitem); //обновляет item в репозитории
   void delete(String nameTodoItem); //удаляет item из репозитория
}
