package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Book extends LibraryObject {
    private String author;
    private String name;
    private String genre;
    private int year;
    private String publisher;
    private int pages;

}

