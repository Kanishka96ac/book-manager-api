package com.nexoura.bookmanager.controller;

import com.nexoura.bookmanager.dto.BookDTO;
import com.nexoura.bookmanager.service.BookService;
import jakarta.validation.Valid;
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
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    // Get All Books
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get Book by ID
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Update Book
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
