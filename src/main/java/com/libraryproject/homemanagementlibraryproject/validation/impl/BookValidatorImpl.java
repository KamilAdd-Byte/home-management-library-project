package com.libraryproject.homemanagementlibraryproject.validation.impl;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.validation.BookValidator;
import org.springframework.stereotype.Component;

@Component
public class BookValidatorImpl implements BookValidator {

    @Override
    public boolean areAllRequiredFieldsNotNull(BookDto book) {
        if (book.getTitle() == null) {
            return false;
        }
        if (book.getAuthor() == null) {
            return false;
        }
        if (book.getStatus() == null) {
            return false;
        }
        return true;
    }
}
