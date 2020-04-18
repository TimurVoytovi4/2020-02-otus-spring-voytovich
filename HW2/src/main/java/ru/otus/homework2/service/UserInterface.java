package ru.otus.homework2.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

import java.util.Locale;

@Service
public class UserInterface {
    private final Locale locale;
    private final IOService ioService;
    private final Test test;
    private final CheckerService service;

    private final MessageSource messageSource;

    public UserInterface(IOService ioService, Test test, MessageSource messageSource, CheckerService service) {
//        locale = new Locale("ru", "RU");
        locale = new Locale("en", "EN");
        this.ioService = ioService;
        this.test = test;
        this.messageSource = messageSource;
        this.service = service;
    }

    public void start() {
        ioService.getOutStream().println(messageSource.getMessage("acquaintance", null, locale));
        test.getPersonDao().storePerson(ioService.getScanner().next(), ioService.getScanner().next());
        testing();
    }

    private void testing() {
        for (String question : test.getQuestionDao().getQuestions(locale.getLanguage())) {
            try {
                askQuestion(question);
            } catch (QuestionnaireException e) {
                ioService.getOutStream().println(e.getMessage());
                askQuestion(question);
            }
        }
        result();
    }

    private void askQuestion(String question) {
        ioService.getOutStream().println(question);
        int value = ioService.getScanner().nextInt();
        if (value > 2 || value < 1) {
            throw new QuestionnaireException(messageSource.getMessage("mistake", null,locale));
        } else
            test.setMark(value);
    }

    private void result() {
        Person person = test.getPersonDao().findPerson();
        ioService.getOutStream().println(messageSource.getMessage("appeal", new String[]{person.getName(), person.getLastName()}, locale));
        service.setResult(messageSource, locale);
        ioService.getOutStream().println(person.getAppraisal());
        ioService.getOutStream().println(messageSource.getMessage("bye", null, locale));
    }
}
