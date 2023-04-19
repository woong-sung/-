package jojo.shop.object.Object;

import jojo.shop.object.Dto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    Dto.ObjectRes objectToDto(Object object);

    List<Dto.ObjectRes> objectListToDto(List<Object> objectList);
}
