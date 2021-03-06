package com.libraryproject.homemanagementlibraryproject.restcontroller;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;
import com.libraryproject.homemanagementlibraryproject.entity.BookCategory;
import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import com.libraryproject.homemanagementlibraryproject.service.BookCategoryService;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    @Autowired
    private BookCategoryService bookCategoryService;

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
    @PostMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
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
    @DeleteMapping(value = "/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletedBook (@PathVariable ("id") Long id) {
       try {
           bookService.deleteBook(id);
       }catch (IllegalArgumentException e){
           e.getStackTrace();
       }
    }

    /**
     * Updates the specified book.
     * @param id book with changes
     * @return response entity with body with updated book
     */
    @PostMapping(value = "/book/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookDto> updateBook (@PathVariable("id") Long id) {
        BookDto book = bookService.getBookById(id);
        bookService.updateBook(book);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping(value = "/book/{id}/borrowed")
    public ResponseEntity<BookDto> lendBook(@PathVariable ("id") Long id, @RequestBody PersonDto person) {
        BookDto lendBook = this.bookService.lendBook(id, person);
        lendBook.setStatus(BookStatus.BORROWED);
        return ResponseEntity.ok().body(lendBook);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable ("id") Long id) {
        BookDto book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }

    /**
     * Returns a list of all category books.
     */
    @GetMapping("/categories")
    public ResponseEntity<List<BookCategory>> getCategoryBooks() {
        List<BookCategory> books = bookCategoryService.getAllCategoryBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/books/{bookCategory}")
    public ResponseEntity<BookCategory> getOneCategoryBooks(@PathVariable ("bookCategory") BookCategory bookCategory) {
        BookCategory booksCategory = bookCategoryService.getOneBook(bookCategory.getId());
        return ResponseEntity.ok().body(booksCategory);
    }
}
