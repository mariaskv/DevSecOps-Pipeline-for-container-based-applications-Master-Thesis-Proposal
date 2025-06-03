package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.BookController;
import com.example.service.BookService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
    
        BookService service = new BookService();
        BookController controller = new BookController(service);
        controller.handleRequest(null); // Προκαλεί τον έλεγχο της εξάρτησης
        SpringApplication.run(App.class, args);
    }
}
