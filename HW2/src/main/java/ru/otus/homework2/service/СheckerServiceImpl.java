package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Person;

import java.util.Locale;

@Service
class CheckerServiceImpl implements CheckerService {

    private final Test test;
    private final Person person;

    @Autowired
    public CheckerServiceImpl(Test test, Person person) {
        this.test = test;
        this.person = person;
    }

    @Override
    public void setResult(MessageSource source, Locale locale) {
        if (test.getMark() == test.getPositiveMark()) {
            person.setAppraisal(source.getMessage("positive", null, locale));
        } else
            person.setAppraisal(source.getMessage("negative", null, locale));
    }
}
