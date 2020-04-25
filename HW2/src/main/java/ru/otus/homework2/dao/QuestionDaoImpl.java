package ru.otus.homework2.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private final Map<String, List<String>> questions;

    public List<String> getQuestions(String locale) {
        return questions.get(locale);
    }
}
