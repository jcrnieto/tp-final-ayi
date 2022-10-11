package com.ayi.tp.rest.serv.app.mapper;

import com.ayi.tp.rest.serv.app.dto.request.DetailClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;
import com.ayi.tp.rest.serv.app.entity.DetailClient;

public interface IDetailClientMapper {

    DetailResponseDTO entityToDto(DetailClient entity);

    DetailClient dtoToEntity(DetailResponseDTO dto);

    DetailClient toEntityByRequest(DetailClientRequestDTO dto);
}
