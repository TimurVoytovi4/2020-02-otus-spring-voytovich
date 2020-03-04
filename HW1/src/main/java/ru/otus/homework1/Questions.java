package ru.otus.homework1;


import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Questions implements Questionnaire {

    @Getter
    private List<String> questions;

    public Questions() {
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream("questioners.csv"))));
        questions = br.lines().collect(Collectors.toList());
    }
}
