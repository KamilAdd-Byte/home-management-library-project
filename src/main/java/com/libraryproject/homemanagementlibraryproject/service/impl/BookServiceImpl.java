package com.libraryproject.homemanagementlibraryproject.service.impl;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.entity.BookEntity;
import com.libraryproject.homemanagementlibraryproject.mapper.BookMapper;
import com.libraryproject.homemanagementlibraryproject.repository.BookRepository;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return bookMapper.mapToDtos(books);
    }

    @Override
    public BookDto addBook(BookDto book) {
        BookEntity bookEntity = bookMapper.mapToEntity(book);
        return bookMapper.mapToDto(bookRepository.save(bookEntity));
    }
}
