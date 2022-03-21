package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 853);
        Book book2 = new Book("The Chronicles of Narnia", 356);
        Book book3 = new Book("Philosophy of Java", 564);
        Book book4 = new Book("Design patterns", 639);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        for (int i = 0; i < library.length; i++) {
            System.out.println("Name of book: " + library[i].getName() + "; Number of pages: " + library[i].getPages());
        }
        System.out.println("Replace books.");
        Book tempBook = library[0];
        library[0] = library[3];
        library[3] = tempBook;
        for (int i = 0; i < library.length; i++) {
            System.out.println("Name of book: " + library[i].getName() + "; Number of pages: " + library[i].getPages());
        }
        System.out.println("Output of books named \"Clean code\"");
        for (int i = 0; i < library.length; i++) {
            if ("Clean code".equals(library[i].getName())) {
                System.out.println("Name of book: " + library[i].getName() + "; Number of pages: " + library[i].getPages());
            }
        }

    }
}
