package org.exo7.entity;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String path;
//    @Transient

    public Image() {}

    public Image(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
