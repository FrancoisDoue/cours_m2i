package org.exercise_inheritance.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.exercise_inheritance.entity.AbstractProduct;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity

public class ElectronicProduct extends AbstractProduct {
    private int batteryDuration;

    @Override
    public String toString() {
        return "ElectronicProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", batteryDuration=" + batteryDuration +
                '}';
    }
}
