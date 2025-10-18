package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Driver {
    private String Name;
    private int experience;
    @Setter
    private boolean available;
    @Setter
    private float money;

    public RepairRequest requestRepair(Car c){return new RepairRequest(c);}
}
