package ru.otus.homework2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.otus.homework2.domain.Person;

@Component
public class PersonDaoImpl implements PersonDao {
    private final Person person;

    @Autowired
    public PersonDaoImpl(Person person) {
        this.person = person;
    }

    @Override
    public void storePerson(String name, String lastName) {
        person.setName(name);
        person.setLastName(lastName);
    }

    @Bean
    @Override
    public Person findPerson() {
        return person;
    }
}
