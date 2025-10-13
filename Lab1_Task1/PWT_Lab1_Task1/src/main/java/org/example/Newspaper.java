package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Newspaper extends LibraryObject {
    private int number;
    private String name;
    private String date;
    private String annotation;
}
