package org.example;

import java.util.Scanner;

public class AlmanacCreator {
    public Almanac almanacCreator(){
        String name;
        String genre;
        int year;
        String publisher;
        int pages;
        String books;

        Scanner scan = new Scanner(System.in);

        System.out.println("Додаємо новий альманах");
        System.out.print(" Назва: ");
        name = scan.nextLine();
        System.out.print(" Жанр: ");
        genre = scan.nextLine();
        System.out.print(" Рік: ");
        year = scan.nextInt();
        scan.nextLine();
        System.out.print(" Видавництво: ");
        publisher = scan.nextLine();
        System.out.print(" Сторінок: ");
        pages = scan.nextInt();
        scan.nextLine();
        System.out.print(" Перелік творів: ");
        books = scan.nextLine();
        return new Almanac(name,genre,year,publisher,pages,books);
    }
}
