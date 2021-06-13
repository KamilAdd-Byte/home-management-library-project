package com.libraryproject.homemanagementlibraryproject.service;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAllBooksShouldReturnAllBooks() {

        // given
        BookDto book1 = createBookDto1();
        BookDto book2 = createBookDto2();
        BookDto addedBook1 = bookService.addBook(book1);
        BookDto addedBook2 = bookService.addBook(book2);

        // when
        List<BookDto> books = bookService.getAllBooks();

        // then
        assertFalse(books.isEmpty());
        assertTrue(books.stream().anyMatch(b -> b.getId().equals(addedBook1.getId())));
        assertTrue(books.stream().anyMatch(b -> b.getId().equals(addedBook2.getId())));
    }

    @Test
    void addBookShouldAddBook() {

        // given
        BookDto book1 = createBookDto1();
        BookDto addedBook1 = bookService.addBook(book1);

        // when
        BookDto book = bookService.getBookById(addedBook1.getId());

        // then
        assertNotNull(book);
        assertEquals(addedBook1.getId(), book.getId());

    }

    @Test
    void getBookByIdShouldFindCorrectBook() {

        // then
        assertThrows(IllegalArgumentException.class, () -> bookService.getBookById(1000000000L));

    }

    private BookDto createBookDto1() {
        BookDto book = new BookDto();
        book.setAuthor("Adam");
        book.setStatus(BookStatus.AVAILABLE);
        book.setDescription("abcd");
        book.setTitle("Tytul12345");
        return book;
    }

    private BookDto createBookDto2() {
        BookDto book = new BookDto();
        book.setAuthor("Jaś");
        book.setStatus(BookStatus.AVAILABLE);
        book.setDescription("abcd11");
        book.setTitle("Tytul54321");
        return book;
    }
}
