package ru.otus.homework2.exceptions;

public class QuestionsLoadingException extends QuestionnaireException {
    public QuestionsLoadingException(Throwable e) {
        super(e.getLocalizedMessage());
    }
}
