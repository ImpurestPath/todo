package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HashMapTodoRepository repozitory = new HashMapTodoRepository();

        repozitory.add(new TodoItem("Jet", "Yelow",false));
        repozitory.add(new TodoItem("Jeta", "Black",false));
        repozitory.add(new TodoItem("Jeta55", "Read",false));

        System.out.println(repozitory.toString());

        repozitory.update(new TodoItem("Jeta55", "Green",true));

        System.out.println(repozitory.toString());

        repozitory.delete("Jeta55");

        System.out.println(repozitory.toString());

        List<TodoItem> listTodoItem = new ArrayList<TodoItem>();

        System.out.println("L I S T");
        System.out.println(repozitory.getAll());
    }
}
