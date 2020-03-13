package ru.otus.homework1.dao;

import lombok.AllArgsConstructor;
import ru.otus.homework1.domain.Person;

@AllArgsConstructor
public class PersonDaoImpl implements PersonDao {
    private Person person;

    @Override
    public void storePerson(String name, String lastName) {
        person.setName(name);
        person.setLastName(lastName);
    }

    @Override
    public Person findPerson() {
        return person;
    }
}
