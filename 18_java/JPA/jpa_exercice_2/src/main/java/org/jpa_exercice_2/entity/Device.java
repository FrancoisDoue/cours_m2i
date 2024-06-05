package org.jpa_exercice_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "device_id")
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "device_computer",
            joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id")
    )
    private List<Computer> computers = new ArrayList<>();

    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
