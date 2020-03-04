package ru.otus.homework1.service;

import java.util.Scanner;

public class IOServiceImpl implements IOService {
    private Scanner scanner;

    public IOServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public IOServiceImpl(String s) {

    }

    @Override
    public String input() {
        return scanner.next();
    }

    @Override
    public int inputInt() {
        return scanner.nextInt();
    }
}
