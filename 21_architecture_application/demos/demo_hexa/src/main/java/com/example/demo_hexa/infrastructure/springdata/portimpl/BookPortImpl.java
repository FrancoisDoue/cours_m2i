package com.example.demo_hexa.infrastructure.springdata.portimpl;

import com.example.demo_hexa.infrastructure.springdata.entity.BookEntity;
import com.example.demo_hexa.infrastructure.springdata.repository.BookEntityRepository;
import com.example.demo_hexa.shared.dto.BookDTO;
import com.example.demo_hexa.shared.port.BookPort;

import java.util.List;

public class BookPortImpl implements BookPort {

    private final BookEntityRepository entityRepository;

    public BookPortImpl(BookEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public BookDTO save(BookDTO book) {
        BookEntity bookEntity = entityRepository.save(new BookEntity(book.getId(), book.getTitle(), book.getAuthor()));
        return new BookDTO(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor());
    }

    @Override
    public List<BookDTO> findAll() {
        List<BookEntity> bookEntities = entityRepository.findAll();
        return bookEntities.stream().map(b -> new BookDTO(b.getId(), b.getTitle(), b.getAuthor())).toList();
    }

    @Override
    public BookDTO findById(int id) {
        BookEntity book = entityRepository.findById(id).orElse(null);
        if (book == null) return null;
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
    }
}
