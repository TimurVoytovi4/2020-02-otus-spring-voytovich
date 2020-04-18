package ru.otus.homework2.service;

import java.io.PrintStream;
import java.util.Scanner;

public interface IOService {
    PrintStream getOutStream();
    Scanner getScanner();
}
