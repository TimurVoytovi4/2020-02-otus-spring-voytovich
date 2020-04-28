package ru.otus.homework2.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Repository
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private final Map<String, List<String>> questions;

    public List<String> getQuestions(String locale) {
        return questions.get(locale);
    }

    public Set<String> getLocales() {
        return questions.keySet();
    }
}
