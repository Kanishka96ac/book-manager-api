package com.nexoura.bookmanager.controller;

import com.nexoura.bookmanager.dto.BookDTO;
import com.nexoura.bookmanager.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book API", description = "CRUD operations for managing books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create a new book")
    @PostMapping
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @Operation(summary = "Get all books")
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @Operation(summary = "Update a book")
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id,
                              @Valid @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @Operation(summary = "Delete a book")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}