package com.libraryproject.homemanagementlibraryproject.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<D, T> {

    /**
     * Maps entity to Dto.
     * @param t entity to be mapped
     * @return Dto object
     */
    D mapToDto(T t);

    /**
     * Maps Dto to entity.
     * @param d dto to be mapped
     * @return entity object
     */
    T mapToEntity(D d);

    /**
     * Maps a lsit of entities to a list of dto's.
     * @param list list of entities
     * @return list of dto's
     */
    default List<D> mapToDtos(List<T> list) {
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    /**
     * Maps a list of dto's to a list of entities.
     * @param list list of dto's
     * @return list of entities
     */
    default List<T> mapToEntities(List<D> list) {
        return list.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
