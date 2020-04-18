package ru.otus.homework2.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.PersonDao;
import ru.otus.homework2.dao.QuestionDao;

@Getter
@Service
public class Test {
    private final QuestionDao questionDao;
    private final PersonDao personDao;
    @Value("${app.mark}")
    private int mark;
    @Value("${app.positiveMark}")
    private int positiveMark;

    @Autowired
    public Test(QuestionDao questionDao, @Qualifier("personDaoImpl") PersonDao personDao) {
        this.questionDao = questionDao;
        this.personDao = personDao;
    }

    public void setMark(int value) {
        mark += value;
    }
}
