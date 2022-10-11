package com.ayi.tp.rest.serv.app.mapper;

import com.ayi.tp.rest.serv.app.dto.request.DirectionsRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Directions;

public interface IDirectionsMapper {

    DirectionsResponseDTO entityToDto(Directions entity);

    Directions dtoToEntity(DirectionsResponseDTO dto);

    Directions toEntityByRequest(DirectionsRequestDTO dto);

}
