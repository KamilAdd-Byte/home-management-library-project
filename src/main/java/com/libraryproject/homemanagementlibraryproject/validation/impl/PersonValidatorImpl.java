package com.libraryproject.homemanagementlibraryproject.validation.impl;

import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;
import com.libraryproject.homemanagementlibraryproject.validation.PersonValidator;
import org.springframework.stereotype.Component;

@Component
public class PersonValidatorImpl implements PersonValidator {

    @Override
    public boolean areAllRequiredFieldsNotNull(PersonDto person) {
        if (person.getFirstName() == null) {
            return false;
        }
        if (person.getLastName() == null) {
            return false;
        }
        if (person.getAddress() == null) {
            return false;
        }
        return true;
    }
}
