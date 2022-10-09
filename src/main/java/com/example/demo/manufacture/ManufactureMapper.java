package com.example.demo.manufacture;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ManufactureMapper {
    ManufactureResponse toResponse(ManufactureEntity entity);

    ManufactureEntity toEntity(ManufactureRequest request);

    @Mapping(target = "id",ignore = true)
    void updateModel( @MappingTarget ManufactureEntity entity,ManufactureRequest request);
}
