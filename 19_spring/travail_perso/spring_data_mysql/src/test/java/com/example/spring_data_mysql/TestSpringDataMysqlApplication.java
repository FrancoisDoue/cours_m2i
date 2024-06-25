package com.example.spring_data_mysql;

import org.springframework.boot.SpringApplication;

public class TestSpringDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringDataMysqlApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
