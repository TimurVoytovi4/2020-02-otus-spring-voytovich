package ru.otus.homework2.service;

import org.springframework.stereotype.Service;
import ru.otus.homework2.domain.Person;
import ru.otus.homework2.exceptions.QuestionnaireException;

@Service
public class UserInterface {
    IOService ioService;
    Test test;

    public UserInterface(IOService ioService, Test test) {
        this.ioService = ioService;
        this.test = test;
    }
    public void start() {
        ioService.getOutStream().println("Ваше имя и фамилия: ");
        test.getDao().storePerson(ioService.getScanner().next(), ioService.getScanner().next());
        testing();
    }

    private void testing() {
        for (String question : test.getQuestionnaire().getQuestions()) {
            try {
                questioned(question);
            } catch (QuestionnaireException e) {
                ioService.getOutStream().println(e.getMessage());
                questioned(question);
            }
        }
        result();
    }

    private void questioned(String allRow) {
        ioService.getOutStream().println(allRow);
        test.setMark(ioService.getScanner().nextInt());
    }

    private void result() {
        Person person = test.getDao().findPerson();
        ioService.getOutStream().println("Уважаемый" + " " + person.getName() + " " + person.getLastName());
        test.setResult();
        ioService.getOutStream().println(test.getDao().findPerson().getAppraisal());
        ioService.getOutStream().println("Всего хорошего.");
    }
}
