package org.tp_billetterie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "event_time", nullable = false)
    private LocalTime eventTime;

    @Column(name = "max_capacity")
    private int maxCapacity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

//    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", maxCapacity=" + maxCapacity +
                ", location=" + location +
                '}';
    }
}
