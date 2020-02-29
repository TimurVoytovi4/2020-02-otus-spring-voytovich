package ru.otus.homework1;


import lombok.Getter;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Questionnaire {
    private int mark;
    @Getter
    private List<String> questions;

    public Questionnaire() {
        questions = new ArrayList<>();
    }

    public String getAppraisal() {
        if (mark == 10) {
            return "Вы добросовестный студент";
        } else {
            return "Вы не добросовестный студент";
        }
    }

    public void setQuestions(Resource resource) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line;
        while ((line = br.readLine())!= null)
            getQuestions().add(line);
    }

    public void setAppraisal(int value) {
        if (value > 2 || value < 1) {
            throw new QuestionnaireException("Вы ввели неправильный ответ");
        }
        mark += value;
    }
}
