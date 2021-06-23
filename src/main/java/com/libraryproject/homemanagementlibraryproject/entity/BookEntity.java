package com.libraryproject.homemanagementlibraryproject.entity;

import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;


    private String description;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private PersonEntity borrower;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(author, that.author) && status == that.status && Objects.equals(description, that.description) && Objects.equals(borrower, that.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, status, description, borrower);
    }
}
