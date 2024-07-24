package com.example.better_todo.entity;

import com.example.better_todo.util.type.Priority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private Priority priority;
    private LocalDate dueDate;

    @Column(name = "created_at")
    private LocalDateTime created;
    @Column(name = "updated_at")
    private LocalDateTime updated;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id")
    private Project project;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

}
