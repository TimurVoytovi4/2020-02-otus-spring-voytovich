package ru.otus.homework2.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Configuration
public class QuestionDaoImpl implements QuestionDao {
    private final Map<String, List<String>> questions;

    public QuestionDaoImpl(@Value("${en.csv}")String en, @Value("${ru.csv}")String ru) {
        this.questions = new HashMap<>();
        questions.put("ru", new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream(ru))))
                .lines().collect(Collectors.toList()));
        questions.put("en", new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream(en))))
                .lines().collect(Collectors.toList()));
    }

    @Override
    public List<String> getQuestions(String locale) {
        return questions.get(locale);
    }
}
