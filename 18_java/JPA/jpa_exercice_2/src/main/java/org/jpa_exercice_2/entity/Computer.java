package org.jpa_exercice_2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Computer {

    @Id @GeneratedValue @Column(name = "computer_id")
    private int id;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "identification_id")
//    @Embedded
    private Identification identification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processor_id")
    private Processor processor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "os_id")
    private OS os;

    // ! mappedBy refer to property, not the class!
    @ManyToMany(mappedBy = "computers")
    private List<Device> devices;

    private void add(Device device) {
        devices.add(device);
    }

}
