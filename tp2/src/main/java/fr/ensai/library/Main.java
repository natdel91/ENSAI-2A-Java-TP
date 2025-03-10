package fr.ensai.library;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());

        // Create an instance of the Library
        Library library = new Library("City Library", new ArrayList<>());

        // Load books from the file
        library.loadBooksFromCSV("books.csv");

        // Create and add magazines to the library
        Magazine mag1 = new Magazine("Tech Monthly", 2024, 50, "1234-5678", 10);
        Magazine mag2 = new Magazine("Science Weekly", 2023, 40, "9876-5432", 5);

        library.addIem(mag1);
        library.addIem(mag2);

        // Display all books
        library.displayItems();
    }

}
