package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.config.LocaleConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class LocaleManagerImpl implements LocaleManager {
    private final LocaleConfig config;
    private final IOService ioService;
    private final MessageSource messageSource;

    public void choseLanguage() {
        List<String> languages = new ArrayList<>(config.getLanguages().keySet());
        ioService.printString(getMessage("language"));
        IntStream.range(0, languages.size()).mapToObj(i -> i + 1 + "." + languages.get(i)).forEach(ioService::printString);
        config.setLocale(Locale.forLanguageTag(config.getLanguages().get(languages.get(ioService.readInt() - 1))));
    }

    public String getMessage(String message, Object... objects) {
        return messageSource.getMessage(message, objects, config.getLocale());
    }
}
