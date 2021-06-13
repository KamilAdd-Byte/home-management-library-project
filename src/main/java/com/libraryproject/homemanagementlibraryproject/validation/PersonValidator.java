package com.libraryproject.homemanagementlibraryproject.validation;

import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;

public interface PersonValidator {

    /**
     * Checks if all the required fields are not null.
     * @param person person to be checked
     * @return false if any of the required fields is null; true otherwise
     */
    boolean areAllRequiredFieldsNotNull(PersonDto person);
}
