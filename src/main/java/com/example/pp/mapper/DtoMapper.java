package com.example.pp.mapper;

import com.example.pp.dto.FruitDto;
import com.example.pp.entity.Apple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoMapper {
    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    @Mapping(source = "name", target = "fruitName")
    @Mapping(source = "price", target = "fruitPrice")
    FruitDto toDto(Apple apple);
}