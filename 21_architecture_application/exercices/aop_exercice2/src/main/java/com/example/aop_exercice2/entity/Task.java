package com.example.aop_exercice2.entity;

import com.example.aop_exercice2.util.constant.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private StatusType status;

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;
}
