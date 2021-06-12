package com.libraryproject.homemanagementlibraryproject.repository;

import com.libraryproject.homemanagementlibraryproject.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
