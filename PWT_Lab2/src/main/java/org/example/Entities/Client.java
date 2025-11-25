package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Client{
    private Integer id;
    private String name;
    private Integer phone_number;
    private Integer discount;
}
