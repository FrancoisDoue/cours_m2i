package tp_hopital.shared.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime consultationDate;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
