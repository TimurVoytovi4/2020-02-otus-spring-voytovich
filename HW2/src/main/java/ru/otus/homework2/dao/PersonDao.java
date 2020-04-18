package ru.otus.homework2.dao;

import ru.otus.homework2.domain.Person;

public interface PersonDao {
    void storePerson(String name, String lastName);
    Person findPerson();
}
