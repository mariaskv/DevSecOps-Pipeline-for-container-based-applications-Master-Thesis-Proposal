package com.example.service;

import com.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    // Default constructor
    public BookService() {
        this.books = new ArrayList<>();
    }

    // Copy constructor
    public BookService(BookService other) {
        this.books = new ArrayList<>(other.books);
    }
    
    // Αντί να επιστρέφουμε την αρχική λίστα, επιστρέφουμε αντίγραφο της λίστας
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Επιστρέφει αντίγραφο της λίστας για προστασία
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
