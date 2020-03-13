package ru.otus.homework1.service;

import lombok.Getter;
import ru.otus.homework1.exceptions.QuestionnaireException;
import ru.otus.homework1.dao.PersonDao;

public class Test {
    @Getter
    private Questionnaire questionnaire;
    @Getter
    private PersonDao dao;
    @Getter
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

    public Test(Questionnaire questionnaire, PersonDao dao) {
        this.questionnaire = questionnaire;
        this.dao = dao;
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
