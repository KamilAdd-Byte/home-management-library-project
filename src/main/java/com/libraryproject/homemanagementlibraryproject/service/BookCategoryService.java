package com.libraryproject.homemanagementlibraryproject.service;

import com.libraryproject.homemanagementlibraryproject.entity.BookCategory;
import java.util.List;

public interface BookCategoryService {

    List<BookCategory> getAllCategoryBooks();

    BookCategory getOneBook(int id);
}
