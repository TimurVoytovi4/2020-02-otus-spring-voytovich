package ru.otus.homework1.Exceptions;

public class QuestionnaireException extends RuntimeException {
    public QuestionnaireException() {
        super("Вы ввели неправильный ответ");
    }
}
