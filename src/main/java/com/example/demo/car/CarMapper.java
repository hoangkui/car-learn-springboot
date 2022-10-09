package com.example.demo.car;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarResponse toResponse(CarEntity entity);
    CarEntity toEntity(CarRequest req);

//    @Mapping(target = "id",ignore = true)
    void updateModel(@MappingTarget CarEntity entity,CarRequest req);
}
