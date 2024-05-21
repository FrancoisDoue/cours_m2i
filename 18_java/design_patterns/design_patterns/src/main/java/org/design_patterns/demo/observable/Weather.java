package org.design_patterns.demo.observable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {
    public double temperature;

}
