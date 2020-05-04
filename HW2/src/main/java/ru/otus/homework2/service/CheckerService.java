package ru.otus.homework2.service;

import ru.otus.homework2.domain.Person;

public interface CheckerService {
    void setResult(Person person);

    void setMark(int value);
}
