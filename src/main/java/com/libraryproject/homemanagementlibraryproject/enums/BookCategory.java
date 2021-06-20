package com.libraryproject.homemanagementlibraryproject.enums;

import lombok.Getter;
import lombok.ToString;

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
}
