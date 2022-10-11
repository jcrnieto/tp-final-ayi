package com.ayi.tp.rest.serv.app.service;

import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;

import java.util.List;

public interface IDirections {

    DirectionsResponseDTO saveDirections(DirectionsResponseDTO directionsResponseDTO);

    List<DirectionsResponseDTO> findAll();

    DirectionsResponseDTO findDirectionById(Long idDirections);

    void delete(Long idDirections);
}
