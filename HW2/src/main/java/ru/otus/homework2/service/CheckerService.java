package ru.otus.homework2.service;

import ru.otus.homework2.domain.Person;

import java.util.Locale;

public interface CheckerService {
    void setResult(Person person, Locale locale);

    void setMark(int value);
}
