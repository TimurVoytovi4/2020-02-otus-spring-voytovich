package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.PersonDao;
import ru.otus.homework2.exceptions.QuestionnaireException;

@Service
public class Test {
    private Questionnaire questionnaire;
    private PersonDao dao;
    private int mark;

    private final int positiveMark;
    private final String negative;
    private final String positive;

    {
        mark = 0;
        positiveMark = 10;
        negative = "Вы не добросовестный студент";
        positive = "Вы добросовестный студент";
    }

    @Autowired
    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @Autowired
    public void setDao(@Qualifier("personDaoImpl") PersonDao dao) {
        this.dao = dao;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @Bean
    public PersonDao getDao() {
        return dao;
    }

    public void setMark(int value) {
        if (!check(value)) {
            mark += value;
        } else
            throw new QuestionnaireException();
    }

    private boolean check(int value) {
        return value > 2 || value < 1;
    }

    public void setResult() {
        if (mark != positiveMark)
            dao.findPerson().setAppraisal(negative);
        else dao.findPerson().setAppraisal(positive);
    }
}
