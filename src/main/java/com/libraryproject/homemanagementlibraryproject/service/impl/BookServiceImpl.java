package com.libraryproject.homemanagementlibraryproject.service.impl;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;
import com.libraryproject.homemanagementlibraryproject.entity.BookEntity;
import com.libraryproject.homemanagementlibraryproject.enums.BookCategory;
import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import com.libraryproject.homemanagementlibraryproject.mapper.BookMapper;
import com.libraryproject.homemanagementlibraryproject.mapper.PersonMapper;
import com.libraryproject.homemanagementlibraryproject.repository.BookRepository;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookValidator bookValidator;
    private final PersonMapper personMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, BookValidator bookValidator, PersonMapper personMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookValidator = bookValidator;
        this.personMapper = personMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return bookMapper.mapToDtos(books);
    }

    @Override
    public BookDto getBookById(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book with given id does not exist"));
        return bookMapper.mapToDto(book);
    }

    @Override
    public BookDto addBook(BookDto book) {
        if (!bookValidator.areAllRequiredFieldsNotNull(book)) {
            throw new IllegalArgumentException("Some fields are null");
        }
        BookEntity bookEntity = bookMapper.mapToEntity(book);
        return bookMapper.mapToDto(bookRepository.save(bookEntity));
    }

    @Override
    public void deleteBook(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        bookRepository.delete(bookEntity);
    }


    @Override
    public BookDto updateBook(BookDto book) {
        BookEntity updateBook = bookRepository.save(bookMapper.mapToEntity(book));
        return bookMapper.mapToDto(updateBook);
    }

    @Override
    public BookCategory getOneCategoryBook(String name) {
        return BookCategory.valueOf(name);
    }


    @Override
    public List<BookCategory> getAllCategoryBook() {
        return new ArrayList<>();
    }


    @Override
    public BookDto lendBook(Long bookId, PersonDto borrower) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book with given id does not exist"));
        bookEntity.setStatus(BookStatus.BORROWED);
        bookEntity.setBorrower(personMapper.mapToEntity(borrower));
        return bookMapper.mapToDto(bookRepository.save(bookEntity));
    }

}
