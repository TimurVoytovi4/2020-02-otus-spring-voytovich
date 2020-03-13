package ru.otus.homework1.service;

import java.io.PrintStream;
import java.util.Scanner;

public interface IOService {
    PrintStream getOutStream();
    Scanner getScanner();
}
