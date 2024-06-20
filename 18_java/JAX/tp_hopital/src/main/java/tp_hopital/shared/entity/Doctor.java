package tp_hopital.shared.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder @Data @AllArgsConstructor
@Entity
public class Doctor extends Account {
    private String firstname;
    private String lastname;
    private String speciality;

    public Doctor() {
        super();
    }
}
