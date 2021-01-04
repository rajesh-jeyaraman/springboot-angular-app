package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init (UserRepository userRepository){
        return args -> {
            Stream.of("Julie", "Ramesh", "Akbar", "Saurab", "Saral")
                    .forEach( name -> {
                        User user = new User();
                        user.setName(name);
                        user.setEmail(name.toLowerCase() + "@domain.com");
                        userRepository.save(user);
                    });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
