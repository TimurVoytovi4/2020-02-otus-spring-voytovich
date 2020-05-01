package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.PersonDao;
import ru.otus.homework2.dao.QuestionDao;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final LocaleManager localeManager;
    private final IOService ioService;
    private final CheckerService checker;
    private final QuestionDao questionDao;
    private final PersonDao personDao;

    public void startTesting() {
        localeManager.choseLanguage();
        ioService.printString(localeManager.getMessage("acquaintance"));
        personDao.storePerson(ioService.readString(), ioService.readString());
        questionDao.getQuestions().forEach(this::askQuestion);
        result();
    }

    private void askQuestion(String question) {
        ioService.printString(question);
        try {
            checker.setMark(ioService.readInt());
        } catch (QuestionnaireException e) {
            ioService.printString(e.getMessage());
            askQuestion(question);
        }
    }

    private void result() {
        Person person = personDao.findPerson();
        ioService.printString(localeManager.getMessage("appeal", person.getName(), person.getLastName()));
        checker.setResult(person);
        ioService.printString(person.getAppraisal());
        ioService.printString(localeManager.getMessage("bye"));
    }
}
