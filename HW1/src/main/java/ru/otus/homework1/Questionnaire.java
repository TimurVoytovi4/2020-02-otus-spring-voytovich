package ru.otus.homework1;


public class Questionnaire {
    private int mark;

    public String getAppraisal() {
        if (mark == 10) {
            return "Вы добросовестный студент";
        } else {
            return "Вы не добросовестный студент";
        }
    }

    public void setAppraisal(int value) {
        if (value > 2 || value < 1) {
            throw new QuestionnaireException("Вы ввели неправильный ответ");
        }
        mark += value;
    }
}
