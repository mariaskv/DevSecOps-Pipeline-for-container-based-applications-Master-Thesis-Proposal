package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

        public void handleRequest(HttpServletRequest request) {
            // Κώδικας που απαιτεί compile-time εξάρτηση
        }
 
    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = new BookService(bookService);  
       
            // String s = null;
            // System.out.println(s.length()); // NullPointerException
        
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks(); // Επιστρέφει αντίγραφο της λίστας
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    @GetMapping(value = "/xss", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String xssEndpoint(@RequestParam("input") String input) {
        return "<html><body>Your input: " + input + "</body></html>";
    }
    
    @GetMapping("/books")
    public String getBooks(@RequestParam String name) {
        return "<html><body>Book: " + name + "</body></html>"; // ⚠ XSS
    }

    @GetMapping("/a")
    public String welcome() {
        return "Welcome to the Book API!";
    }
}
