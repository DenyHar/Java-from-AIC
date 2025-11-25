package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Staff{
    private Integer id;
    private String name;
    private Integer phone_number;
    private String contact_address;
    private String position;
}
