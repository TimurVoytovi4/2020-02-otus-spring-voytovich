package ru.otus.homework2.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework2.domain.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
    private final Person person;

    public PersonDaoImpl(Person person) {
        this.person = person;
    }

    public Person findPerson() {
        return person;
    }
}
