package com.libraryproject.homemanagementlibraryproject.repository;

import com.libraryproject.homemanagementlibraryproject.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
