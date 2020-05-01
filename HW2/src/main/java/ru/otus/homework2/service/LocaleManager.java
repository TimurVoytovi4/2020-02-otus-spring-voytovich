package ru.otus.homework2.service;

public interface LocaleManager {
    void choseLanguage();
    String getMessage(String message, Object ...objects);
}
