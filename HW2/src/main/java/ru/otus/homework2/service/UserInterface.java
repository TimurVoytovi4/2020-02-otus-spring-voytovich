package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.PersonDao;
import ru.otus.homework2.dao.QuestionDao;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserInterface {
    private Locale locale;
    private final IOService ioService;
    private final CheckerService checker;
    private final QuestionDao questionDao;
    private final PersonDao personDao;
    private final MessageSource messageSource;

    public void start() {
        languageSelection();
        ioService.printString(messageSource.getMessage("acquaintance", null, locale)+"\n");
        personDao.storePerson(ioService.readString(), ioService.readString());
        testing();
    }

    private void languageSelection() {
        try {
            ioService.printString(messageSource.getMessage("language", null, Locale.getDefault()));
            questionDao.getLocales().forEach(ioService::printString);
            String val = ioService.readString();
            if (questionDao.getLocales().contains(val)) {
                locale = new Locale(val, val.toUpperCase());
            }else {
                throw new QuestionnaireException(messageSource.getMessage("mistake", null, locale));
            }
        } catch (QuestionnaireException e) {
            ioService.printString(e.getMessage());
            languageSelection();
        }
    }

    private void testing() {
        for (String question : questionDao.getQuestions(locale.getLanguage())) {
            askQuestion(question);
        }
        result();
    }

    private void askQuestion(String question) {
        ioService.printString(question);
        try {
            int value = Integer.parseInt(ioService.readString());
            if (value > 2 || value < 1) {
                throw new QuestionnaireException(messageSource.getMessage("mistake", null, locale));
            } else
                checker.setMark(value);
        } catch (QuestionnaireException e) {
            ioService.printString(e.getMessage());
            askQuestion(question);
        } catch (Exception e) {
            askQuestion(question);
        }
    }

    private void result() {
        Person person = personDao.findPerson();
        ioService.printString(messageSource.getMessage("appeal", new String[]{person.getName(), person.getLastName()}, locale));
        checker.setResult(person, locale);
        ioService.printString(person.getAppraisal());
        ioService.printString(messageSource.getMessage("bye", null, locale));
    }
}
