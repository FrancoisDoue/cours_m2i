package org.jpa_exercice_2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Processor {
    @Id @GeneratedValue @Column(name = "processor_id")
    private int id;
    String name;
    int core;
    double speed;

    @OneToMany(mappedBy = "processor")
    private List<Computer> computers = List.of();

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", core=" + core +
                ", speed=" + speed;
    }

    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        this.computers.forEach(computer -> sb.append(computer.toString()).append('\n'));
        return "[ " + this + ", computer = " + sb + " ]";
    }
}
