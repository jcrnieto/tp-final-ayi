package com.ayi.tp.rest.serv.app.mapper.impl;

import com.ayi.tp.rest.serv.app.dto.request.DirectionsRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Directions;
import com.ayi.tp.rest.serv.app.mapper.IDirectionsMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DirectionsMapperImpl implements IDirectionsMapper {
    private final ModelMapper modelMapper;



    @Override
    public DirectionsResponseDTO entityToDto(Directions entity) {
        return modelMapper.map(entity, DirectionsResponseDTO.class );
    }

    @Override
    public Directions dtoToEntity(DirectionsResponseDTO dto) {
        return modelMapper.map(dto, Directions.class);
    }

    @Override
    public Directions toEntityByRequest(DirectionsRequestDTO dto) {
        Directions personEntity = new Directions();
        modelMapper.map(dto, personEntity);
        return personEntity;
    }
}
