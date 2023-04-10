package com.elayachiabdelmajid.libMaroc.utils.mapper;

import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

public class EntityDtoMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static <D, E> D toDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <D, E> E toEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }

    public static <D, E> PaginationResponse<D> toDtoPageable(Page<E> entityPage, Class<D> dtoClass) {
        return new PaginationResponse<>(entityPage.getTotalPages(), entityPage.getContent().stream().map(entity -> toDto(entity, dtoClass)).collect(Collectors.toList()),
                entityPage.getTotalElements(), entityPage.getSize(), entityPage.getNumberOfElements());
    }
}

