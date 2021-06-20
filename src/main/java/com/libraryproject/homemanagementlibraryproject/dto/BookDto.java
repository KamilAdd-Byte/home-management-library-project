package com.libraryproject.homemanagementlibraryproject.dto;

import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;

    private String title;

    private String author;

    private BookStatus status;

    private String description;

    private PersonDto borrower;
}
