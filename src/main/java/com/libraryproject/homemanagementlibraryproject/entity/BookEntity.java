package com.libraryproject.homemanagementlibraryproject.entity;

import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private BookStatus status;

    private String description;

    @OneToOne
    private PersonEntity owner;

    @OneToOne
    private PersonEntity borrower;


}
