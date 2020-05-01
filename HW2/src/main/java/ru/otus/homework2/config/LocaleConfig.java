package ru.otus.homework2.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

@Component
public class LocaleConfig {
    private final Map<String, String> questionsFiles;
    @Getter
    private final Map<String, String> languages;
    @Getter
    @Setter
    private Locale locale;

    public LocaleConfig(@Value("#{${valuesMap}}") Map<String, String> questionsFiles,
                        @Value("#{${languages}}") Map<String, String> languages) {
        this.questionsFiles = questionsFiles;
        this.languages = languages;
        locale = languages.values().stream().findFirst().map(Locale::forLanguageTag)
                .orElseThrow(() -> new RuntimeException("Available language does not exist"));
    }

    public String getQuestionsFile() {
        return questionsFiles.get(locale.toLanguageTag());
    }
}
