package org.exercice_1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int note;

    @Column(name = "comment_date", columnDefinition = "timestamp default now()", insertable = false)
    private LocalDateTime commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", note=" + note +
                ", commentDate=" + commentDate +
                '}';
    }
}
