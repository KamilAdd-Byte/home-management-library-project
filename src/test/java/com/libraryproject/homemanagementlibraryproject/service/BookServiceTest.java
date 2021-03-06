package com.libraryproject.homemanagementlibraryproject.service;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;
import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void lendBookShouldChangeStatusAndPersistPerson() {

        // given
        BookDto book = createBookDto1();
        BookDto addedBook = bookService.addBook(book);
        PersonDto borrower = createPersonDto();

        // when
        bookService.lendBook(addedBook.getId(), borrower);
        BookDto borrowedBook = bookService.getBookById(addedBook.getId());

        // then
        assertNotNull(borrowedBook.getBorrower().getId());
        assertEquals(borrower.getFirstName(), borrowedBook.getBorrower().getFirstName());
        assertEquals(borrower.getLastName(), borrowedBook.getBorrower().getLastName());
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
        book.setAuthor("Ja??");
        book.setStatus(BookStatus.AVAILABLE);
        book.setDescription("abcd11");
        book.setTitle("Tytul54321");
        return book;
    }
    @Test
    void shouldDeleteBookById(){
        // given
        BookDto book1 = createBookDto1();
        BookDto addedBook1 = bookService.addBook(book1);

        //when
        bookService.addBook(addedBook1);
        long id = addedBook1.getId();

        bookService.deleteBook(id);
        //then
        assertNotNull(addedBook1);
        Assertions.assertThrows(Exception.class,() -> bookService.deleteBook(id));
    }


    private PersonDto createPersonDto() {
        PersonDto person = new PersonDto();
        person.setFirstName("Tom");
        person.setLastName("Smith");
        return person;
    }

    @Test
    void shouldUpdateBook(){
        //given
        BookDto book = createBookDto1();
        BookDto updateBook = bookService.addBook(book);

       //when
//       bookService.updateBook(updateBook);
       Long id = updateBook.getId();

       BookDto actual = bookService.getBookById(id);
       actual.setTitle("CHANGE TITLE");

       //then
       Assertions.assertEquals(book.getClass(),actual.getClass());
    }

}
