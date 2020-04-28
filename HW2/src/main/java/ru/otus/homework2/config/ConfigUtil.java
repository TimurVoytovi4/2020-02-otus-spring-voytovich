package ru.otus.homework2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class ConfigUtil {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Map<String, List<String>> setParams(@Value("#{${valuesMap}}") Map<String, String> val) {
        Map<String, List<String>> map = new HashMap<>();
        val.forEach((key, value) -> map.put(key, new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResourceAsStream(value))))
                .lines()
                .collect(Collectors.toList())));
        return map;
    }

    @Bean
    public Scanner setScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public PrintStream setOutStream() {
        return System.out;
    }
}
