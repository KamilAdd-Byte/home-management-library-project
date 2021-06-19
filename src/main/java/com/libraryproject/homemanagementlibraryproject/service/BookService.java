package com.libraryproject.homemanagementlibraryproject.service;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;

import java.awt.print.Book;
import java.util.List;

public interface BookService {

    /**
     * Return all books from the database.
     * @return
     */
    List<BookDto> getAllBooks();

    /**
     * Returns a book with the provided id.
     * @param id id of the book to be returned
     * @throws IllegalArgumentException if a book the given id does not exist
     * @return book with the provided id
     */
    BookDto getBookById(Long id);

    /**
     * Adds a provided book to the database.
     * @param book book to be added
     * @return added book
     */
    BookDto addBook(BookDto book);

    /**
     * Deletes a provided book with the spcified id.
     * @param id id of the book to be deleted
     * @throws IllegalArgumentException if a book with the specified id does not exist
     */
    void deleteBook(Long id);

    /**
     * Lends a book with the specified id. The status of the book is changed and a person borrowing the book is
     * assigned and saved in the database.
     * @param bookId id of the book to be borrowed
     * @param borrower person borrowing the book
     */
    BookDto lendBook(Long bookId, PersonDto borrower);

    /**
     * Updates the provided book in the database.
     */
    BookDto updateBook(BookDto book);
}
