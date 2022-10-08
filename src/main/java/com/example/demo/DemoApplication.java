package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	JDBCTodoRepository repository;

	public static void main(String[] args) {
		JDBCTodoRepository jdbcTodoRepository = new JDBCTodoRepository();

		SpringApplication.run(DemoApplication.class, args);
		jdbcTodoRepository.add(new TodoItem("Jeta", "Black",false));;


//		HashMapTodoRepository repozitory = new HashMapTodoRepository();
//
//		repozitory.add(new TodoItem("Jet", "Yelow",false));
//		repozitory.add(new TodoItem("Jeta", "Black",false));
//		repozitory.add(new TodoItem("Jeta55", "Read",false));
//
//		System.out.println(repozitory.toString());
//
//		repozitory.update(new TodoItem("Jeta55", "Green",true));
//
//		System.out.println(repozitory.toString());
//
//		repozitory.delete("Jeta55");
//
//		System.out.println(repozitory.toString());
//
//		List<TodoItem> listTodoItem = new ArrayList<TodoItem>();
//
//		System.out.println("L I S T");
//		System.out.println(repozitory.getAll());
	}

	@Override
	public void run(String... args) throws Exception, NullPointerException {
		logger.info("start");
		repository.getAll().forEach(todoItem -> logger.info(todoItem.toString()));
		logger.info(repository.get("'Implement methods").toString());
	}
}
