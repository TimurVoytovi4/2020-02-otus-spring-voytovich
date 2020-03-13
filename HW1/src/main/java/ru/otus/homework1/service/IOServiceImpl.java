package ru.otus.homework1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.PrintStream;
import java.util.Scanner;

@AllArgsConstructor
@Getter
public class IOServiceImpl implements IOService {

    private Scanner scanner;
    private PrintStream outStream;

}
