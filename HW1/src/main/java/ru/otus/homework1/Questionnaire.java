package ru.otus.homework1;


import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Questionnaire {
    private int mark;
    @Getter
    private List<String> questions;

    public Questionnaire() {
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream("questionary.csv"))));
        questions = br.lines().collect(Collectors.toList());
    }

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
