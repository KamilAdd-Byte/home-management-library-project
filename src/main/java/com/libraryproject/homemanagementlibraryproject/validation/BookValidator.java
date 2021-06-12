package com.libraryproject.homemanagementlibraryproject.validation;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;

public interface BookValidator {

    boolean areAllRequiredFieldsNotNull(BookDto book);
}
