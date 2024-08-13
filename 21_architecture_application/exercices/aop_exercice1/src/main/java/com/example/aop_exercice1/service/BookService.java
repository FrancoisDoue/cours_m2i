package com.example.aop_exercice1.service;

import com.example.aop_exercice1.annotation.Logger;
import com.example.aop_exercice1.annotation.Performance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private int cnt = 0;
    private final HashMap<Integer,String> books = new HashMap<>(Map.of(
            ++cnt, "Oui-Oui à la plage",
            ++cnt, "Martine ne trouve pas que c'était mieux avant"
    ));

    @Performance
    @Logger
    public HashMap<Integer,String> getBooks() {
        return books;
    }

    @Performance
    @Logger
    public String getBook(int id) {
        return books.get(id);
    }

    @Performance
    @Logger
    public void createBook(String title) {
        books.put(++cnt, title);
    }

    @Performance
    @Logger
    public void deleteBook(int id) {
        books.remove(id);
    }

}
