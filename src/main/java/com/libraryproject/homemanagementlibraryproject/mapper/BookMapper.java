package com.libraryproject.homemanagementlibraryproject.mapper;

import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements AbstractMapper<BookDto, BookEntity> {


    @Override
    public BookDto mapToDto(BookEntity bookEntity) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapToEntity(BookDto bookDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(bookDto, BookEntity.class);
    }
}
