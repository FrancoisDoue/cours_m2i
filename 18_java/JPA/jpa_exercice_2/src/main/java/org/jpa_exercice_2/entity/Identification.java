package org.jpa_exercice_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Embeddable
public class Identification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "identification_id")
    private int id;

    private String ip;

    @OneToOne(mappedBy = "identification", fetch = FetchType.LAZY)
    private Computer computer;

    @Override
    public String toString() {
        return "Identification{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String toFullString() {
        return "[ " + this.toString() + ", computer=" + this.computer + " ]";
    }

}
