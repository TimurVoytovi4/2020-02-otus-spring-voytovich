package ru.otus.homework2.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.PrintStream;

@Data
@Component
public class ConsoleContext {
    private InputStream in = System.in;
    private PrintStream out = System.out;
}
