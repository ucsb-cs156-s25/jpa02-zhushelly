package edu.ucsb.cs156.spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Every Spring Boot application has a main class with a main method 
 * that starts the application.  This always involves calling
 * SpringApplication.run(), passing in the class object for the class
 * containg the main, and any command line arguments.
 */

@SpringBootApplication
public class Application {
    /**
     * main class for Spring Boot application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
