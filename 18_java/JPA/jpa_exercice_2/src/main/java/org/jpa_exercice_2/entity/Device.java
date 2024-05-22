package org.jpa_exercice_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "device_id")
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "device_computer",
            joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id")
    )
    private List<Computer> computers;

    public void add(Computer computer) {
        computers.add(computer);
    }
}
