package com.example.microservice_ex1.infra.springdata.repository;

import com.example.microservice_ex1.infra.springdata.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
