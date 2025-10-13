package org.example;

import java.util.Scanner;

public class NewspaperCreator {
    public Newspaper newspaperCreator(){
        int number;
        String name;
        String date;
        String annotation;

        Scanner scan = new Scanner(System.in);

        System.out.println("Додаємо нову газету");
        System.out.print(" Номер: ");
        number = scan.nextInt();
        scan.nextLine();
        System.out.print(" Назва: ");
        name = scan.nextLine();
        System.out.print(" Дата: ");
        date = scan.nextLine();
        System.out.print(" Колонки: ");
        annotation = scan.nextLine();
        return new Newspaper(number,name,date,annotation);
    }
}
