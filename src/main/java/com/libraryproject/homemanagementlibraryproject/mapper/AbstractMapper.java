package com.libraryproject.homemanagementlibraryproject.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<D, T> {

    D mapToDto(T t);

    T mapToEntity(D d);

    default List<D> mapToDtos(List<T> list) {
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    default List<T> mapToEntities(List<D> list) {
        return list.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
