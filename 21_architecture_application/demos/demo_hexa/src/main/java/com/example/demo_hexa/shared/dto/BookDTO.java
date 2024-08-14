package com.example.demo_hexa.shared.dto;

public class BookDTO {

    private int id;
    private String title;
    private String author;

    public BookDTO(int id, String title, String author) {
        this(title, author);
        this.id = id;
    }

    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
