package ru.otus.homework1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Demo {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Resource resource = context.getResource("classpath:questionary.csv");
        UserInterface ui = context.getBean(UserInterface.class);
        ui.setReader(resource);
        ui.start();
    }
}
