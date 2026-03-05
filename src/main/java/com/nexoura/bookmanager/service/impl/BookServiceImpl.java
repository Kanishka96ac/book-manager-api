package com.nexoura.bookmanager.service.impl;

import com.nexoura.bookmanager.dto.BookDTO;
import com.nexoura.bookmanager.entity.Book;
import com.nexoura.bookmanager.repository.BookRepository;
import com.nexoura.bookmanager.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = mapToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return mapToDTO(savedBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return mapToDTO(book);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setPublishedYear(bookDTO.getPublishedYear());

        Book updatedBook = bookRepository.save(existingBook);

        return mapToDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Convert Entity → DTO
    private BookDTO mapToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getPublishedYear()
        );
    }

    // Convert DTO → Entity
    private Book mapToEntity(BookDTO dto) {
        return new Book(
                dto.getId(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getPrice(),
                dto.getPublishedYear()
        );
    }
}