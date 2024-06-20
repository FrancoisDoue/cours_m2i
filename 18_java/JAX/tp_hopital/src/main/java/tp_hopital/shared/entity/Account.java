package tp_hopital.shared.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder @Data @AllArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Account {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(nullable = false, unique = true)
    protected String login;
    @Column(nullable = false)
    protected String password;

    public Account() {}
}
