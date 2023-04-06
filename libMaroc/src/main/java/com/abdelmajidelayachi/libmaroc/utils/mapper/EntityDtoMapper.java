package com.abdelmajidelayachi.libmaroc.utils.mapper;

import org.modelmapper.ModelMapper;

public class EntityDtoMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static <D, E> D toDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <D, E> E toEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }

}

