package com.example.entity;

import com.example.dto.BookDTO;
import com.example.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Borrow {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @Column(name = "book_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long bookId;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Transient private BookDTO book;
    @Transient private UserDTO user;

    @PrePersist
    protected void onCreate() {
        borrowDate = LocalDate.now();
    }
}
