package com.libraryproject.homemanagementlibraryproject.service.impl;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.entity.BookEntity;
import com.libraryproject.homemanagementlibraryproject.mapper.BookMapper;
import com.libraryproject.homemanagementlibraryproject.repository.BookRepository;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookValidator bookValidator;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, BookValidator bookValidator) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookValidator = bookValidator;
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
}
