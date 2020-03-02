package ru.otus.homework1;


import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Questionnaire {
    private final int positiveMark;
    private final String negative;
    private final String positive;
    private int mark;
    @Getter
    private List<String> questions;

    {
        positiveMark = 10;
        negative = "Вы не добросовестный студент";
        positive = "Вы добросовестный студент";
    }

    public Questionnaire() {
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream("questioners.csv"))));
        questions = br.lines().collect(Collectors.toList());
    }

    public String getAppraisal() {
        if (mark == positiveMark) {
            return positive;
        }
        return negative;
    }

    public void setAppraisal(int value) {
        if (!check(value)) {
            mark += value;
        } else
            throw new QuestionnaireException();
    }

    private boolean check(int value) {
        return value > 2 || value < 1;
    }
}
