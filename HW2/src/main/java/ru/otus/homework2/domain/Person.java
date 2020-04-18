package ru.otus.homework2.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Person {
    private String name;
    private String lastName;
    private String appraisal;
}
