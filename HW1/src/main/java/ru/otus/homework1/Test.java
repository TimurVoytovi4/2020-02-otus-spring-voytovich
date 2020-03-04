package ru.otus.homework1;

import lombok.Getter;
import lombok.Setter;
import ru.otus.homework1.Exceptions.QuestionnaireException;
import ru.otus.homework1.domain.Person;

@Getter
@Setter
public class Test {
    Questionnaire questionnaire;
    Person person;
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

    public Test(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
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
        if (mark!= positiveMark)
            person.setAppraisal(negative);
        else person.setAppraisal(positive);
    }
}
