package com.example.ex6_forum.repository;

import com.example.ex6_forum.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaryRepository extends JpaRepository<Commentary, Integer> {

}
