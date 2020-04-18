package ru.otus.homework2.service;


import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
@Getter
public class IOServiceImpl implements IOService {
    private Scanner scanner;
    private PrintStream outStream;

    @Bean
    public void setScanner() {
        this.scanner = new Scanner(System.in);
    }

    @Bean
    public void setOutStream() {
        this.outStream = System.out;
    }
}
