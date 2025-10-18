package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Jobcard {
    private int id;
    private String destination;
    private float distance;
    private String cargoType;
    private float cargoWeight;
}
