package fr.ensai.library;

public class Student extends Person {
    // Attributes
    private String name;
    private int age;
    private String academicYear;
    private Boolean isClassDelegate;

    // Constructor
    public Student(String name, int age, String academicYear, Boolean isClassDelegate) {
        super(name);
        this.age = age;
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", academicYear=" + academicYear + ", isClassDelegate="
                + isClassDelegate + '}';
    }
}
