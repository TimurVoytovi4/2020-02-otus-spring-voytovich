package ru.otus.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework2.service.TestingServiceImpl;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Runner {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Runner.class );
        var testingService = context.getBean(TestingServiceImpl.class);

        testingService.startTesting();
    }
}
