package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Schedule {
    private Integer staff_id;
    private String day_of_week;
    private LocalTime begin_time;
    private LocalTime end_time;
    private LocalDate date;
}
