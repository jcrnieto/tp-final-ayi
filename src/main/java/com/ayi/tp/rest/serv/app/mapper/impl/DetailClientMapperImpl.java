package com.ayi.tp.rest.serv.app.mapper.impl;

import com.ayi.tp.rest.serv.app.dto.request.DetailClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;
import com.ayi.tp.rest.serv.app.entity.DetailClient;
import com.ayi.tp.rest.serv.app.mapper.IDetailClientMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DetailClientMapperImpl implements IDetailClientMapper {

    private final ModelMapper modelMapper;


    @Override
    public DetailResponseDTO entityToDto(DetailClient entity) {
        return modelMapper.map(entity, DetailResponseDTO.class );
    }

    @Override
    public DetailClient dtoToEntity(DetailResponseDTO dto) {
        return modelMapper.map(dto, DetailClient.class);
    }

    @Override
    public DetailClient toEntityByRequest(DetailClientRequestDTO dto) {
        return modelMapper.map(dto, DetailClient.class);
    }
}
