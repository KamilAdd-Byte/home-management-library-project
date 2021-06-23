package com.libraryproject.homemanagementlibraryproject.service.impl;

import com.libraryproject.homemanagementlibraryproject.entity.BookCategory;
import com.libraryproject.homemanagementlibraryproject.repository.BookCategoryRepository;
import com.libraryproject.homemanagementlibraryproject.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    /**
     *
     * @return All category books
     */
    @Override
    public List<BookCategory> getAllCategoryBooks() {
        List<BookCategory> categories = new ArrayList<>();
        categories.add(new BookCategory(1,"CRIMINAL"));
        categories.add(new BookCategory(2,"KIDS"));
        categories.add(new BookCategory(3,"PSYCHOLOGIST"));
        categories.add(new BookCategory(4,"ROMANTIC"));
        categories.add(new BookCategory(5,"POETRY"));
        categories.add(new BookCategory(6,"EDUCATION"));
        categories.add(new BookCategory(7,"PROGRAMMING"));
        categories.add(new BookCategory(8,"FANTASTIC"));
        categories.add(new BookCategory(9,"HORROR"));
        categories.add(new BookCategory(10,"NON-FICTION"));
        categories.add(new BookCategory(11,"FANTASY"));
        categories.add(new BookCategory(12,"THRILLER"));
        categories.add(new BookCategory(13,"OTHERS"));
        return categories;
    }

    /**
     *
     * @param id get category books by id
     * @return some category books by id
     */
    @Override
    public BookCategory getOneBook(int id) {
        BookCategory category = bookCategoryRepository.getOne(id);
        return category;
    }
}
