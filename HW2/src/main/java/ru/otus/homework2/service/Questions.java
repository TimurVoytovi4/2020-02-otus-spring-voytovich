package ru.otus.homework2.service;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Questions implements Questionnaire {

    @Bean
    @Override
    public List<String> getQuestions() {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream("questioners.csv"))))
                .lines().collect(Collectors.toList());
    }
}
