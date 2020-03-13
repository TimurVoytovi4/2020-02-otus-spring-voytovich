package ru.otus.homework1.dao;

import ru.otus.homework1.domain.Person;

public interface PersonDao {
    void storePerson(String name, String lastName);
    Person findPerson();
}
