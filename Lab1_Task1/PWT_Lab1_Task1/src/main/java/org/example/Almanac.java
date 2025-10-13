package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Almanac extends LibraryObject {
    private String name;
    private String genre;
    private int year;
    private String publisher;
    private int pages;
    private String books;
}
