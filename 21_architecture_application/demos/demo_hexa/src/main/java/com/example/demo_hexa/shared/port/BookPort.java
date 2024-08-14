package com.example.demo_hexa.shared.port;

import com.example.demo_hexa.domain.entity.Book;
import com.example.demo_hexa.shared.dto.BookDTO;

import java.util.List;

public interface BookPort {
    BookDTO save(BookDTO book);
    List<BookDTO> findAll();
    BookDTO findById(int id);
}
