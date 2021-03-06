package ru.otus.homework2.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String lastName;
    private String appraisal;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
