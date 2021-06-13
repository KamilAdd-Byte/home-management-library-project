package com.libraryproject.homemanagementlibraryproject.service;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto addBook(BookDto book);

    void deleteBook(Long id);

    void lendBook(Long bookId, PersonDto borrower);

    BookDto updateBookById(Long id,BookDto book);
}
