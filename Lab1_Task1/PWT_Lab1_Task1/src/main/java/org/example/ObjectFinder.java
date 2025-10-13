package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class ObjectFinder {
    public LibraryObject findObject(HashSet<LibraryObject> libraryCatalog){
        Scanner scan = new Scanner(System.in);
        int choice;

        String name;
        int number;
        LibraryObject Obj = null;

        System.out.flush();
        System.out.println(" 1. Книга.\n 2. Альманах.\n 3. Газета.");
        choice = scan.nextInt();
        scan.nextLine();
        System.out.print(" Назва: ");
        name = scan.nextLine();

        switch (choice) {
            case 1:
                for (LibraryObject o : libraryCatalog){
                    if (o.getName().equals(name) && o instanceof Book){
                        Obj = o;
                    }
                }
                break;
            case 2:
                for (LibraryObject o : libraryCatalog){
                    if (o.getName().equals(name) && o instanceof Almanac){
                        Obj = o;
                    }
                }
                break;
            case 3:
                for (LibraryObject o : libraryCatalog){
                    System.out.print(" Номер випуску: ");
                    number = scan.nextInt();
                    scan.nextLine();
                    if (o instanceof Newspaper && o.getName().equals(name) && o.getNumber() == number){
                        Obj = o;
                    }
                }
                break;
        }
        return Obj;
    }
}
