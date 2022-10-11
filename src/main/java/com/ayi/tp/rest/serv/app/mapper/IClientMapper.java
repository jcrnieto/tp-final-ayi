package com.ayi.tp.rest.serv.app.mapper;

import com.ayi.tp.rest.serv.app.dto.request.ClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Client;

public interface IClientMapper {

    ClientResponseDTO entityToDto(Client entity);

    Client dtoToEntity(ClientRequestDTO dto);


}
