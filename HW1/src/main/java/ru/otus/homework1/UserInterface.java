package ru.otus.homework1;

import ru.otus.homework1.Exceptions.QuestionnaireException;
import ru.otus.homework1.service.IOService;

public class UserInterface {
    IOService ioService;
    Test test;

    public UserInterface(IOService ioService, Test test) {
        this.ioService = ioService;
        this.test = test;
    }

    public void start(){
        System.out.println("Ваше имя и фамилия: ");
        test.person.setName(ioService.input());
        test.person.setLastName(ioService.input());
        testing();
    }

    private void testing() {
        for (String question : test.getQuestionnaire().getQuestions()) {
            try {
                questioned(question);
            } catch (QuestionnaireException e) {
                System.out.println(e.getMessage());
                questioned(question);
            }
        }
        result();
    }

    private void questioned(String allRow) {
        System.out.println(allRow);
        test.setMark(ioService.inputInt());
    }

    private void result() {
        System.out.println("Уважаемый" + " " + test.person.getName() + " " + test.person.getLastName());
        test.setResult();
        System.out.println(test.person.getAppraisal());
        System.out.println("Всего хорошего.");
    }
}
