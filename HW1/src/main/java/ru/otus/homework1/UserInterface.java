package ru.otus.homework1;

import ru.otus.homework1.domain.Person;

import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Person p1;

    public UserInterface(Person person) {
        p1 = person;
    }

    public void start(){
        System.out.println("Ваше имя и фамилия: ");
        p1.setName(sc.next());
        p1.setLastName(sc.next());
        testing();
    }

    private void testing() {
        for (String allRow : p1.getData().getQuestions()) {
            try {
                questioned(allRow);
            } catch (QuestionnaireException e) {
                System.out.println(e.getMessage());
                questioned(allRow);
            }
        }
        result();
    }

    private void questioned(String allRow) {
        System.out.println(allRow);
        p1.getData().setAppraisal(sc.nextInt());
    }

    private void result() {
        System.out.println("Уважаемый" + " " + p1.getName() + " " + p1.getLastName());
        System.out.println(p1.getData().getAppraisal());
        System.out.println("Всего хорошего.");
    }
}
