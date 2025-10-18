package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

enum CarCondition {WORKING, BROKEN}

@Getter
@AllArgsConstructor
@ToString
public class Car {
    private int number;
    private int loadCapacity;
    private int difficulty;
    private String type;
    @Setter
    private CarCondition condition;
    @Setter
    private boolean available;
}
