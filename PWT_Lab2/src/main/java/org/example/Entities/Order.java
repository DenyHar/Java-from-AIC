package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Order {
    private Integer id;
    private Integer menu_id;
    private Integer waiter_id;
    private Integer client_id;
    private LocalDate date;
}
