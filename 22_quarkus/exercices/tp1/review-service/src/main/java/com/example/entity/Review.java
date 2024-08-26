package com.example.entity;

import com.example.dto.BookDTO;
import com.example.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @Column(name = "book_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long bookId;

    private int notation;

    private String content;

    @Transient
    private UserDTO user;

    @Transient
    private BookDTO book;

}
