package ru.otus.homework2.dao;

import java.util.List;
import java.util.Set;

public interface QuestionDao {
    List<String> getQuestions(String locale);
    Set<String> getLocales();
}
