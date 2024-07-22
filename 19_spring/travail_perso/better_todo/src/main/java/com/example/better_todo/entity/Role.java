package com.example.better_todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Role implements GrantedAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true, nullable=false)
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }

}
