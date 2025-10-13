package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookCreator BC = new BookCreator();
        AlmanacCreator AC = new AlmanacCreator();
        NewspaperCreator NC = new NewspaperCreator();
        HashSet<LibraryObject> LibraryCatalog = new HashSet<>();
        ObjectFinder objectFinder = new ObjectFinder();

        LibraryCatalog.add(new Book("Ігор", "Книга", "Фентезі", 2020, "Перша Друкарня", 200));
        LibraryCatalog.add(new Almanac("Альманах1", "Народні байки", 2020, "Перша Друкарня", 200, "Книга 7, Книга 4, Книга 9"));
        LibraryCatalog.add(new Newspaper(15,"Правда","12.10.2025", "1. Перша. 2. Друга. 3. Третя"));
        LibraryCatalog.add(new Book("Ігор", "Книга2", "Фентезі", 2022, "Друга Друкарня", 225));
        LibraryCatalog.add(new Almanac("Альманах2", "Історичний", 2020, "Перша Друкарня", 678, "Історична Книга1, Книга 5, Книга H"));
        LibraryCatalog.add(new Newspaper(13,"Правда","10.10.2025", "1. Перша. 2. Друга. 3. Третя"));

        Random rni = new Random();
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean run = true;
        boolean userTypeChoice = false;

        String stringInput;
        int intInput;
        LibraryObject obj;
        LibraryObject objBuff;

        while (run) {
            System.out.println("Меню:\n 1. Додати об'єкт по типу.\n 2. Додавання випадкового типу.\n 3. Видалити об'єкт\n 4. Редагувати об'єкт.\n 5. Вивести каталог.\n 6. Пошук. \n 7. Вийти.");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1: //Додати по типу
                    System.out.flush();
                    System.out.println(" 1. Книга.\n 2. Альманах.\n 3. Газета.");
                    choice = scan.nextInt();
                    scan.nextLine();
                    userTypeChoice = true;
                case 2: //Додати випадковий тип
                    if (!userTypeChoice) {
                        choice = rni.nextInt(3) + 1;
                    }
                    switch (choice) {
                        case 1:
                            LibraryCatalog.add(BC.bookCreator());
                            System.out.println("Додано книгу");
                            break;
                        case 2:
                            LibraryCatalog.add(AC.almanacCreator());
                            System.out.println("Додано альманах");
                            break;
                        case 3:
                            LibraryCatalog.add(NC.newspaperCreator());
                            System.out.println("Додано газету");
                            break;
                    }
                    break;
                case 3: //Видалити
                    obj = objectFinder.findObject(LibraryCatalog);
                    if (obj != null){
                        LibraryCatalog.remove(obj);
                        System.out.println("Видалено.");
                    }
                    else{
                        System.out.println("Об'єкт не знайдено.");
                    }
                    break;
                case 4: //Змінити
                    obj = objectFinder.findObject(LibraryCatalog);
                    objBuff = obj;
                    boolean edited = false;

                    switch (obj){
                        case null -> System.out.println("Об'єкт не знайдено.");
                        case  Book _ -> {
                            System.out.println("Який параметр бажаєте змінити?");
                            System.out.println(" 1. Автора.\n 2. Назву.\n 3. Жанр.\n 4. Рік.\n 5. Видавництво.\n 6. К-ть сторінок.");
                            choice = scan.nextInt();
                            scan.nextLine();
                            switch (choice){
                                case 1:
                                    System.out.print("Новий автор: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setAuthor(stringInput);
                                    edited = true;
                                    break;
                                case 2:
                                    System.out.print("Нова назва: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setName(stringInput);
                                    edited = true;
                                    break;
                                case 3:
                                    System.out.print("Новий жанр: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setGenre(stringInput);
                                    edited = true;
                                    break;
                                case 4:
                                    System.out.print("Новий рік: ");
                                    intInput = scan.nextInt();
                                    scan.nextLine();
                                    objBuff.setYear(intInput);
                                    edited = true;
                                    break;
                                case 5:
                                    System.out.print("Нове видавництво: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setPublisher(stringInput);
                                    edited = true;
                                    break;
                                case 6:
                                    System.out.print("Нова к-ть сторінок: ");
                                    intInput = scan.nextInt();
                                    scan.nextLine();
                                    objBuff.setPages(intInput);
                                    edited = true;
                                    break;
                            }
                            if (edited){
                                LibraryCatalog.remove(obj);
                                LibraryCatalog.add(new Book(objBuff.getAuthor(),objBuff.getName(),objBuff.getGenre(),objBuff.getYear(),objBuff.getPublisher(),objBuff.getPages()));
                            }
                        }
                        case  Almanac _ -> {
                            System.out.println("Який параметр бажаєте змінити?");
                            System.out.println(" 1. Назву.\n 2. Жанр.\n 3. Рік.\n 4. Видавництво.\n 5. К-ть сторінок.\n 6. Перелік творів.");
                            choice = scan.nextInt();
                            scan.nextLine();
                            switch (choice){
                                case 1:
                                    System.out.print("Нова назва: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setName(stringInput);
                                    edited = true;
                                    break;
                                case 2:
                                    System.out.print("Новий жанр: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setGenre(stringInput);
                                    edited = true;
                                    break;
                                case 3:
                                    System.out.print("Новий рік: ");
                                    intInput = scan.nextInt();
                                    scan.nextLine();
                                    objBuff.setYear(intInput);
                                    edited = true;
                                    break;
                                case 4:
                                    System.out.print("Нове видавництво: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setPublisher(stringInput);
                                    edited = true;
                                    break;
                                case 5:
                                    System.out.print("Нова к-ть сторінок: ");
                                    intInput = scan.nextInt();
                                    scan.nextLine();
                                    objBuff.setPages(intInput);
                                    edited = true;
                                    break;
                                case 6:
                                    System.out.print("Новий список творів: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setBooks(stringInput);
                                    edited = true;
                                    break;
                            }
                            if (edited){
                                LibraryCatalog.remove(obj);
                                LibraryCatalog.add(new Almanac(objBuff.getName(),objBuff.getGenre(),objBuff.getYear(),objBuff.getPublisher(),objBuff.getPages(),objBuff.getBooks()));
                            }
                        }
                        case  Newspaper _ -> {
                            System.out.println("Який параметр бажаєте змінити?");
                            System.out.println(" 1. Номер.\n 2. Назву.\n 3. Дату.\n 4. Перелік колонок.");
                            choice = scan.nextInt();
                            scan.nextLine();
                            switch (choice){
                                case 1:
                                    System.out.print("Новий номер: ");
                                    intInput = scan.nextInt();
                                    scan.nextLine();
                                    objBuff.setNumber(intInput);
                                    edited = true;
                                    break;
                                case 2:
                                    System.out.print("Нова назва: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setName(stringInput);
                                    edited = true;
                                    break;
                                case 3:
                                    System.out.print("Нова дата: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setDate(stringInput);
                                    edited = true;
                                    break;
                                case 4:
                                    System.out.print("Новий перелік колонок: ");
                                    stringInput = scan.nextLine();
                                    objBuff.setAnnotation(stringInput);
                                    edited = true;
                                    break;
                            }
                            if (edited){
                                LibraryCatalog.remove(obj);
                                LibraryCatalog.add(new Newspaper(objBuff.getNumber(),objBuff.getName(),objBuff.getDate(),objBuff.getAnnotation()));
                            }
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + obj);
                    }
                    LibraryCatalog.remove(obj);
                    System.out.println("Видалено.");
                    System.out.println("Redact");
                    break;
                case 5: // Показати
                    System.out.println(" Згрупувати y/n");
                    stringInput = scan.nextLine();
                    if (stringInput.equals("n")){
                        for (LibraryObject o : LibraryCatalog) {
                            System.out.println(o);
                        }
                    } else if (stringInput.equals("y")) {
                        for (LibraryObject o : LibraryCatalog){
                            if (o instanceof Book){
                                System.out.println(o);
                            }
                        }
                        for (LibraryObject o : LibraryCatalog){
                            if (o instanceof Almanac){
                                System.out.println(o);
                            }
                        }
                        for (LibraryObject o : LibraryCatalog){
                            if (o instanceof Newspaper){
                                System.out.println(o);
                            }
                        }
                    }
                    else {
                        System.out.println(" Введено неправильний параметр.");
                    }
                    break;
                case 6: //Знайти
                    System.out.println(" 1. Назвою.\n 2. Видавництвом.\n 3. Роком.\n 4. Автором.");
                    choice = scan.nextInt();
                    scan.nextLine();
                    switch (choice){
                        case 1:
                            System.out.print(" Назва: ");
                            stringInput = scan.nextLine();
                            for (LibraryObject o : LibraryCatalog){
                                if (o.getName().equals(stringInput)){
                                    System.out.println(o);
                                }
                            }
                            break;
                        case 2:
                            System.out.print(" Видавництво: ");
                            stringInput = scan.nextLine();
                            for (LibraryObject o : LibraryCatalog){
                                if (o.getPublisher() != null && o.getPublisher().equals(stringInput)){
                                    System.out.println(o);
                                }
                            }
                            break;
                        case 3:
                            System.out.print(" Рік: ");
                            try {
                                intInput = scan.nextInt();
                            }catch (Exception e){
                                System.out.println("Рік має бути цілим числом.");
                                scan.nextLine();
                                break;
                            }
                            scan.nextLine();
                            for (LibraryObject o : LibraryCatalog){
                                if (o.getYear() == intInput){
                                    System.out.println(o);
                                }
                            }
                            break;
                        case 4:
                            System.out.print(" Автор: ");
                            stringInput = scan.nextLine();
                            for (LibraryObject o : LibraryCatalog){
                                if (o.getAuthor() != null && o.getAuthor().equals(stringInput)){
                                    System.out.println(o);
                                }
                            }
                            break;
                    }
                    break;
                case 7: //Кінець
                    System.out.println("Finalize");
                    run = false;
                    break;
                default:
                    System.out.println("Такої опції немає");
            }
        }
    }
}
