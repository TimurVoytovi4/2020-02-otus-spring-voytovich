package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Person;

import java.util.Locale;

@Service
class CheckerServiceImpl implements CheckerService {
    private int mark;
    private final int positiveMark;

    private final MessageSource source;

    public CheckerServiceImpl(@Value("${app.positiveMark}")int positiveMark, MessageSource source) {
        this.positiveMark = positiveMark;
        this.source = source;
    }

    public void setResult(Person person, Locale locale) {
        if (mark == positiveMark) {
            person.setAppraisal(source.getMessage("positive", null, locale));
        } else
            person.setAppraisal(source.getMessage("negative", null, locale));
    }

    public void setMark(int value) {
        mark += value;
    }
}
