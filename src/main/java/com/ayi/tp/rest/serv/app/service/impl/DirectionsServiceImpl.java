package com.ayi.tp.rest.serv.app.service.impl;

import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Directions;
import com.ayi.tp.rest.serv.app.mapper.IDetailClientMapper;
import com.ayi.tp.rest.serv.app.mapper.IDirectionsMapper;
import com.ayi.tp.rest.serv.app.repository.IDetailClientRepository;
import com.ayi.tp.rest.serv.app.repository.IDirectionsRepository;
import com.ayi.tp.rest.serv.app.service.IDirections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionsServiceImpl implements IDirections {

    @Autowired
    private IDirectionsRepository directionsRepository;

    @Autowired
    private IDirectionsMapper directionsMapper;


    @Override
    public DirectionsResponseDTO saveDirections(DirectionsResponseDTO directionsResponseDTO) {

        Directions directions = directionsRepository.save(directionsMapper.dtoToEntity(directionsResponseDTO));
        return directionsMapper.entityToDto(directions);
    }

    @Override
    public List<DirectionsResponseDTO> findAll() {

        List<DirectionsResponseDTO> directionsResponseDTOS;

        List<Directions> directions = directionsRepository.findAll();

        directionsResponseDTOS = directions.stream().map(direction -> directionsMapper.entityToDto(direction))
                .collect(Collectors.toList());
        return directionsResponseDTOS;
    }

    @Override
    public DirectionsResponseDTO findDirectionById(Long idDirections) {

         DirectionsResponseDTO directionsResponseDTO;

        Optional<Directions> entity = directionsRepository.findById(idDirections);

        directionsResponseDTO = directionsMapper.entityToDto(entity.get());

        return directionsResponseDTO;
    }

    @Override
    public void delete(Long idDirections) {

        Optional<Directions> directions = directionsRepository.findById(idDirections);

        if(directions.isPresent()){
            directionsRepository.deleteById(idDirections);
        }else {
            throw new RuntimeException("Error. ID not found.");
        }

    }
}
