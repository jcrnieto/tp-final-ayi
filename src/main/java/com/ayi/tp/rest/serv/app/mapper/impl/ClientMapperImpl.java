package com.ayi.tp.rest.serv.app.mapper.impl;

import com.ayi.tp.rest.serv.app.dto.request.ClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Client;
import com.ayi.tp.rest.serv.app.mapper.IClientMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapperImpl implements IClientMapper {

    private final ModelMapper modelMapper;

    @Override
    public ClientResponseDTO entityToDto(Client entity){

        return modelMapper.map(entity, ClientResponseDTO.class );
    }

    @Override
    public Client dtoToEntity(ClientRequestDTO request) {

        return modelMapper.map(request, Client.class);
    }



}
