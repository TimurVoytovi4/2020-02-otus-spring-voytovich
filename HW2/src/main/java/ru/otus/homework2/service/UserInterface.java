package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.PersonDao;
import ru.otus.homework2.dao.QuestionDao;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserInterface {
    private Locale locale;
    private final List<Locale> locales;
    private final InteractionService ioService;
    private final CheckerService checker;
    private final QuestionDao questionDao;
    private final PersonDao personDao;
    private final MessageSource messageSource;

    public void start() {
        languageSelection();
        ioService.printString(messageSource.getMessage("acquaintance", null, locale));
        personDao.findPerson().setName(ioService.readString());
        personDao.findPerson().setLastName(ioService.readString());
        testing();
    }

    private void languageSelection() {
        ioService.printString(messageSource.getMessage("language", null, Locale.getDefault()));
        switch (Integer.parseInt(ioService.readString())){
            case 1:
                locale = locales.get(0);
                break;
            case 2:
                locale = locales.get(1);
                break;
        }
    }

    private void testing() {
        for (String question : questionDao.getQuestions(locale.getLanguage())) {
            try {
                askQuestion(question);
            } catch (QuestionnaireException e) {
                ioService.printString(e.getMessage());
                askQuestion(question);
            }
        }
        result();
    }

    private void askQuestion(String question) {
        ioService.printString(question);
        int value = Integer.parseInt(ioService.readString());
        if (value > 2 || value < 1) {
            throw new QuestionnaireException(messageSource.getMessage("mistake", null, locale));
        } else
            checker.setMark(value);
    }

    private void result() {
        Person person = personDao.findPerson();
        ioService.printString(messageSource.getMessage("appeal", new String[]{person.getName(), person.getLastName()}, locale));
        checker.setResult(person, locale);
        ioService.printString(person.getAppraisal());
        ioService.printString(messageSource.getMessage("bye", null, locale));
    }
}
