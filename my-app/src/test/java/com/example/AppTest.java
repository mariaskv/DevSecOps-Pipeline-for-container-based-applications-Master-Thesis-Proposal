package com.example;

import com.example.controller.BookController;
import com.example.model.Book;
import com.example.service.BookService;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void testBookManagement() {

        // Δημιουργία του BookService και BookController
        BookService bookService = new BookService();
        BookController bookController = new BookController(bookService);

        // Προσθήκη βιβλίου
        Book book1 = new Book(1, "Effective Java", "Joshua Bloch");
        bookController.addBook(book1);

        // Έλεγχος πλήθους βιβλίων
        Assert.assertEquals(1, bookController.getAllBooks().size());

        // Ανάκτηση βιβλίου με ID 1
        Book retrievedBook = bookController.getBookById(1);
        Assert.assertNotNull(retrievedBook); // Έλεγχος ότι δεν είναι null
        Assert.assertEquals("Effective Java", retrievedBook.getTitle());

        // Εκτύπωση λίστας βιβλίων
        System.out.println("All Books: " + bookController.getAllBooks());
    }
}
