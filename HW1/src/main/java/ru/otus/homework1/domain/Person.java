package ru.otus.homework1.domain;


import ru.otus.homework1.Questionnaire;

public class Person {
    private String name;
    private String lastName;
    private Questionnaire data;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Questionnaire getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setData(Questionnaire data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
