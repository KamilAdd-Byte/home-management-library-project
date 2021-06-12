package com.libraryproject.homemanagementlibraryproject.mapper;

import com.libraryproject.homemanagementlibraryproject.dto.PersonDto;
import com.libraryproject.homemanagementlibraryproject.entity.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements AbstractMapper<PersonDto, PersonEntity> {

    @Override
    public PersonDto mapToDto(PersonEntity personEntity) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(personEntity, PersonDto.class);
    }

    @Override
    public PersonEntity mapToEntity(PersonDto personDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(personDto, PersonEntity.class);
    }
}
