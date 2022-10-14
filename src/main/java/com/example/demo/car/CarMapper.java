package com.example.demo.car;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    CarResponse toResponse(CarEntity entity);

    @Mapping(target = "manu.id", source = "manu_id")
    CarEntity toEntity(CarRequest req);

}
