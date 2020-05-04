package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

@Service
class CheckerServiceImpl implements CheckerService {
    private int mark;
    private final int positiveMark;
    private final LocaleManager manager;

    public CheckerServiceImpl(@Value("${app.positiveMark}") int positiveMark, LocaleManager manager) {
        this.positiveMark = positiveMark;
        this.manager = manager;
    }

    public void setResult(Person person) {
        if (mark == positiveMark) {
            person.setAppraisal(manager.getMessage("positive"));
        } else
            person.setAppraisal(manager.getMessage("negative"));
    }

    public void setMark(int value) {
        if (value > 2 || value < 1) {
            throw new QuestionnaireException(manager.getMessage("mistake"));
        } else
            mark += value;
    }
}
