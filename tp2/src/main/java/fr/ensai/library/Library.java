package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    // Attributes
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans; // List to store ongoing loans
    private List<Loan> completedLoans; // List to store completed (returned) loans

    // Constructor
    public Library(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    // Method to add a book to the library
    public void addIem(Item book) {
        items.add(book);
    }

    // Method to display all books in the library
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The library has no books.");
        } else {
            System.out.println("Books in " + name + " library:");
            for (Item book : items) {
                System.out.println(book.toString());
            }
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addIem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to create a loan and add it to the active loans list
    public void createLoan(Student student, Item item, Date startDate) {
        Loan newLoan = new Loan(student, item, startDate);
        activeLoans.add(newLoan);
        System.out.println("Loan created: " + newLoan.toString());
    }

    // Method to mark a loan as completed (return the item and move it to completed
    // loans)
    public void completeLoan(Loan loan) {
        loan.setReturnDate(new java.util.Date()); // Set the return date
        activeLoans.remove(loan); // Remove from active loans
        completedLoans.add(loan); // Add to completed loans
        System.out.println("Loan completed: " + loan.toString());
    }

}
