package com.nexoura.bookmanager.controller;

import com.nexoura.bookmanager.entity.Book;
import com.nexoura.bookmanager.service.BookService;
import jakarta.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create Book
    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get Book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Update Book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
