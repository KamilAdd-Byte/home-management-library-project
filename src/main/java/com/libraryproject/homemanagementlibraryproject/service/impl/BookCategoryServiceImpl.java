package com.libraryproject.homemanagementlibraryproject.service.impl;

import com.libraryproject.homemanagementlibraryproject.entity.BookCategory;
import com.libraryproject.homemanagementlibraryproject.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {


    @Override
    public List<BookCategory> getAllCategoryBooks() {
        List<BookCategory> categories = new ArrayList<>();
        categories.add(new BookCategory(1,"CRIMINAL"));
        categories.add(new BookCategory(2,"KIDS"));
        categories.add(new BookCategory(1,"PSYCHOLOGIST"));
        categories.add(new BookCategory(1,"ROMANTIC"));
        categories.add(new BookCategory(1,"POETRY"));
        categories.add(new BookCategory(1,"EDUCATION"));
        categories.add(new BookCategory(1,"PROGRAMMING"));
        categories.add(new BookCategory(1,"FANTASTIC"));
        categories.add(new BookCategory(1,"OTHERS"));
        return categories;
    }
}
