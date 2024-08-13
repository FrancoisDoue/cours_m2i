package com.example.infrastructure_spring_data.repository;

import com.example.infrastructure_spring_data.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventEntityRepository extends JpaRepository<EventEntity, Integer> {

}
