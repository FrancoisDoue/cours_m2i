package org.exercise_inheritance.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.exercise_inheritance.entity.AbstractProduct;

import javax.persistence.Entity;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor @NoArgsConstructor
@Data @SuperBuilder
@Entity
public class FoodProduct extends AbstractProduct {
    private LocalDate expirationDate;

    @Override
    public String toString() {
        return "FoodProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
