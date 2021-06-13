package com.libraryproject.homemanagementlibraryproject.restcontroller;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    /**
     * Returns a list of all books in the db as json.
     */
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    /**
     * Adds a new book to the db from the request body.
     * @param book book to saved
     */
    @PostMapping("/book")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
        if (!bookValidator.areAllRequiredFieldsNotNull(book)) {
            // TODO: 13.06.2021
        }
        BookDto savedBook = bookService.addBook(book);
        return ResponseEntity.ok().body(savedBook);
    }
}
