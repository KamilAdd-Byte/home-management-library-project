package com.libraryproject.homemanagementlibraryproject.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public enum BookCategory {
    CRIMINAL("Kryminał"),
    PSYCHOLOGIST("Psychologia"),
    PROGRAMMING("Programowanie"),
    FANTASTIC("Fantastyka"),
    SAILING("Żeglarstwo"),
    ROMANTIC("Romans"),
    POETRY("Poezja"),
    EDUCATION("Pedagogika, edukacja"),
    KIDS("Dla dzieci"),
    OTHERS("Inne");

    public String description;

    BookCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<BookCategory> allCategoryBook = new ArrayList<>();
}
