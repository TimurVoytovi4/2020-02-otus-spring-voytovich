package ru.otus.homework2.dao;

import java.util.List;

public interface QuestionDao {
    List<String> getQuestions(String locale);
}
