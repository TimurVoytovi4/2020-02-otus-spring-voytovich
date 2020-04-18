package ru.otus.homework2.exceptions;

public class QuestionnaireException extends RuntimeException {
    public QuestionnaireException() {
        super("Вы ввели неправильный ответ");
    }
}
