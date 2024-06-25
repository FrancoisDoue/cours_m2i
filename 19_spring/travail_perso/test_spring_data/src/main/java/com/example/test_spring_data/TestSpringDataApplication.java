package com.example.test_spring_data;

import com.example.test_spring_data.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestSpringDataApplication {

	private static final Logger log = LoggerFactory.getLogger(TestSpringDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestSpringDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			repository.save(Task.builder().title("Task 1").description("A simple task").build());
			repository.save(Task.builder().title("Task 2").description("Another task").build());

			log.info("Found tasks:");
			repository.findAll().forEach(System.out::println);

		};
	}

}
