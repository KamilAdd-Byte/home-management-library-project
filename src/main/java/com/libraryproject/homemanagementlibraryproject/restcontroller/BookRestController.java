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
@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping(path = "/book", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
        if (!bookValidator.areAllRequiredFieldsNotNull(book)) {
            // TODO: 13.06.2021
        }
        BookDto savedBook = bookService.addBook(book);
        return ResponseEntity.ok().body(savedBook);
    }

    /**
     * Deletes a book with the specified id.
     * @param id id of the book to be deleted
     */
    @DeleteMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletedBook (@PathVariable ("id") Long id) {
        bookService.deleteBook(id);
    }

    /**
     * Updates the specified book.
     * @param book book with changes
     * @return response entity with body with updated book
     */
    @PutMapping(value = "book")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDto> updateBook (@RequestBody BookDto book){
        BookDto updateBook = bookService.updateBook(book);
        return ResponseEntity.ok().body(updateBook);
    }
}
