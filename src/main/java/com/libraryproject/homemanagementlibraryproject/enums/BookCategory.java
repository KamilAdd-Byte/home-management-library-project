package com.libraryproject.homemanagementlibraryproject.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public enum BookCategory {
    CRIMINAL,
    PSYCHOLOGIST,
    PROGRAMMING,
    FANTASTIC,
    SAILING,
    ROMANTIC,
    POETRY,
    EDUCATION,
    KIDS,
    OTHERS;

//    public String description;
//
//    BookCategory(String description) {
//        this.description = description;
//    }
//
//    public String getDescription() {
//        return description;
//    }

    public List<BookCategory> allCategoryBook = new ArrayList<>();
}
