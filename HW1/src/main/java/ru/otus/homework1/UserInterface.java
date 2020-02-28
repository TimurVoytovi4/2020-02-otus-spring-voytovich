package ru.otus.homework1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    CSVReader reader = new CSVReader(new FileReader("HW1/src/main/resources/questionary.csv"));
    List<String[]> allRows = reader.readAll();
    Person p1;

    public UserInterface() throws Exception {
    }

    public void start() {
        System.out.println("Ваше имя и фамилия: ");
        p1 = new Person(sc.next(), sc.next());
        testing();
    }

    private void testing() {
        for (String[] allRow : allRows) {
            try {
                questioned(allRow);
            }catch (QuestionnaireException e){
                System.out.println(e.getMessage());
                questioned(allRow);
            }
        }
        result();
    }

    private void questioned(String[] allRow) {
        System.out.println(Arrays.toString(allRow));
        p1.data.setAppraisal(sc.nextInt());
    }

    private void result() {
            System.out.println("Уважаемый" + " " + p1.getName() + " " + p1.getLastName());
            System.out.println(p1.data.getAppraisal());
            System.out.println("Всего хорошего.");
    }
}
