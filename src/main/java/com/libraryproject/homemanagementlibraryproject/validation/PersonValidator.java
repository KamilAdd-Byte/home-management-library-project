package com.libraryproject.homemanagementlibraryproject.validation;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;

public interface PersonValidator {

    boolean areAllRequiredFieldsNotNull(PersonDto person);
}
