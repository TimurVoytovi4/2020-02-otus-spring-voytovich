package ru.otus.homework1;

public class QuestionnaireException extends RuntimeException {
    public QuestionnaireException() {
        super("Вы ввели неправильный ответ");
    }
}
