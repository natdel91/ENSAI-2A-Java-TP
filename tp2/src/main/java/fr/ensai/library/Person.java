package fr.ensai.library;

public class Person {
    // Attributes
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
        ;
    }

    @Override
    public String toString() {
        return "name =" + name;
    }
}
