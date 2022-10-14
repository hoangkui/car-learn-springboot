package com.example.demo.manufacture;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManufactureMapper {
    ManufactureResponse toResponse(ManufactureEntity entity);


    @Mapping(target = "id", ignore = true)
    ManufactureEntity toEntity(ManufactureRequest request);

}
