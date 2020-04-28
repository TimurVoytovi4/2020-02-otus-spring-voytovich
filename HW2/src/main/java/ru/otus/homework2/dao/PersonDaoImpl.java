package ru.otus.homework2.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
    private Person person;

    public Person findPerson() {
        return person;
    }

    public void storePerson(String name, String lastName) {
        person = new Person(name,lastName);
    }
}
