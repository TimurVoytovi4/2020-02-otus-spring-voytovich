package ru.otus.homework2.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.config.LocaleConfig;
import ru.otus.homework2.exceptions.QuestionsLoadingException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private final LocaleConfig config;

    public List<String> getQuestions() {
        try (var br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream(config.getQuestionsFile()))))) {
            return br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new QuestionsLoadingException(e);
        }
    }
}
