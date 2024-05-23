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
public class HousingProduct extends AbstractProduct {
    private int width;
    private int height;
    private int depth;

    @Override
    public String toString() {
        return "HousingProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
