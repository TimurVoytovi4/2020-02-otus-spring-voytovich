package ru.otus.homework1;


public class Person {
    private String name;
    private String lastName;
    Questionnaire data;

    public Person(String name, String lastName ) {
        data = new Questionnaire();
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
