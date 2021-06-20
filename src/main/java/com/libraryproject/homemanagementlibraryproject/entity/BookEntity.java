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

    @Column(nullable = false,length = 30)
    private String title;

    @Column(nullable = false,length = 30)
    private String author;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    private String description;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private PersonEntity borrower;

}
