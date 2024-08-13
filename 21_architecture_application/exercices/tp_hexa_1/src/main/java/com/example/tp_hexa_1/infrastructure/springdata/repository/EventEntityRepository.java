package com.example.tp_hexa_1.infrastructure.springdata.repository;

import com.example.tp_hexa_1.infrastructure.springdata.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventEntityRepository extends JpaRepository<EventEntity, Integer> {

}
