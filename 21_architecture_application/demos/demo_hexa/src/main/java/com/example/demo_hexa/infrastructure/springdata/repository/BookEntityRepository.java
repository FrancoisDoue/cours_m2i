package com.example.demo_hexa.infrastructure.springdata.repository;


import com.example.demo_hexa.infrastructure.springdata.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity, Integer> {

}
