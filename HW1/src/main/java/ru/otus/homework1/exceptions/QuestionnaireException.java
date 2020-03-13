package ru.otus.homework1.exceptions;

public class QuestionnaireException extends RuntimeException {
    public QuestionnaireException() {
        super("Вы ввели неправильный ответ");
    }
}
