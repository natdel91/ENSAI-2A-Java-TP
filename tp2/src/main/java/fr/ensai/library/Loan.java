package fr.ensai.library;

import java.util.Date;

public class Loan {
    // Attributes
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    // Constructor
    public Loan(Student student, Item item, Date startDate) {
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = null; // returnDate is null initially
    }

    // Method to set the return date
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Method to return a String representation of the loan
    @Override
    public String toString() {
        return "Item " + item + " borrowed by " + student + ".";
    }
}
