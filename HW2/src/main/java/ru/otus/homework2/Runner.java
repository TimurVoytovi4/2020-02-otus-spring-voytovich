package ru.otus.homework2;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.homework2.service.UserInterface;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Runner {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource(){
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Runner.class );
        var ui = context.getBean(UserInterface.class);

        ui.start();
    }
}
