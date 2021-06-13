package com.libraryproject.homemanagementlibraryproject.restcontroller;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/book")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
        if (!bookValidator.areAllRequiredFieldsNotNull(book)) {
            // TODO: 13.06.2021
        }
        BookDto savedBook = bookService.addBook(book);
        return ResponseEntity.ok().body(savedBook);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletedBook (@PathVariable ("id") Long id) {
        bookService.deleteBook(id);
    }

}
