package ru.otus.homework2.service;


import org.springframework.stereotype.Service;
import ru.otus.homework2.config.ConsoleContext;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner scanner;
    private final PrintStream outStream;

    public IOServiceImpl(ConsoleContext context) {
        this.scanner = new Scanner(context.getIn());
        this.outStream = context.getOut();
    }

    public void printString(String message) {
        outStream.println(message);
    }

    public String readString() {
        return scanner.next();
    }

    public int readInt() {
        return scanner.nextInt();
    }
}
