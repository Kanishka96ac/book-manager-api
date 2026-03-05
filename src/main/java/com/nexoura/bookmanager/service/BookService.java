package com.nexoura.bookmanager.service;

import com.nexoura.bookmanager.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO saveBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);

}