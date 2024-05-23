package org.tp_billeterie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "event_date")
    private LocalDate eventDate;
    @Column(name = "event_time")
    private LocalTime eventTime;
    @Column(name = "max_capacity")
    private int maxCapacity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
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
