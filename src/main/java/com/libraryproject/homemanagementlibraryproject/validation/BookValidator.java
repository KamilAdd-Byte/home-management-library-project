package com.libraryproject.homemanagementlibraryproject.validation;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;

public interface BookValidator {

    /**
     * Checks if all the required fields are not null.
     * @param book book to be checked
     * @return false if any of the required fields is null; true otherwise
     */
    boolean areAllRequiredFieldsNotNull(BookDto book);
}
