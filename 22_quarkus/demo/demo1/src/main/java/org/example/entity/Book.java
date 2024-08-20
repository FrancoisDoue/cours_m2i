package org.example.entity;

import io.vertx.codegen.json.annotations.JsonGen;
import jakarta.ws.rs.FormParam;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Book {
    @FormParam("id")
    private int id;
    @FormParam("title")
    private String title;
    @FormParam("author")
    private String author;
    @FormParam("year")
    private int year;
    @FormParam("genre")
    private String genre;
}
