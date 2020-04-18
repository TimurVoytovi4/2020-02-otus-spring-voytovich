package ru.otus.homework2.service;

import org.springframework.context.MessageSource;

import java.util.Locale;

public interface CheckerService {
    void setResult(MessageSource source, Locale locale);
}
