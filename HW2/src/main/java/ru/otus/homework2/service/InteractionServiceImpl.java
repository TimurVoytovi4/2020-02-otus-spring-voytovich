package ru.otus.homework2.service;


import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
@Getter
public class InteractionServiceImpl implements InteractionService {
    private final Scanner scanner;
    private final PrintStream outStream;

    public InteractionServiceImpl(Scanner scanner, PrintStream outStream) {
        this.scanner = scanner;
        this.outStream = outStream;
    }

    public void printString(String s) {
        outStream.println(s);
    }

    public String readString() {
        return scanner.nextLine();
    }
}
