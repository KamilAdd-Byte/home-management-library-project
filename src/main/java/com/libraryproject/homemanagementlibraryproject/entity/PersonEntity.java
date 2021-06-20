package com.libraryproject.homemanagementlibraryproject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

}
