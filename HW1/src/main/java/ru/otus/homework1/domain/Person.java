package ru.otus.homework1.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.otus.homework1.Questionnaire;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private String lastName;
    private Questionnaire data;
}
