package org.example;

import java.util.Scanner;

public class BookCreator {
    public Book bookCreator(){
        String author;
        String name;
        String genre;
        int year;
        String publisher;
        int pages;

        Scanner scan = new Scanner(System.in);

        System.out.println("Додаємо нову книгу");
        System.out.print(" Автор: ");
        author = scan.nextLine();
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
        return new Book(author,name,genre,year,publisher,pages);
        }
    }

