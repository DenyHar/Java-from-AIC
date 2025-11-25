package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Menu {
    private Integer id;
    private String name_ua;
    private String name_eng;
    private String type;
    private Double price;
}
