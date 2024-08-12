package com.example.aop_exercice1.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private int cnt = 0;
    @Getter
    private final HashMap<Integer,String> books = new HashMap<>(Map.of(
            ++cnt, "Oui-Oui à la plage",
            ++cnt, "Martine ne trouve pas que c'était mieux avant"
    ));

    public String getBook(int id) {
        return books.get(id);
    }

    public void createBook(String title) {
        books.put(++cnt, title);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }

}
