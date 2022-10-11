package com.ayi.tp.rest.serv.app.service;

import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;

import java.util.List;
import java.util.ListIterator;

public interface IDetailClientService {

    DetailResponseDTO saveDetailClient(DetailResponseDTO detailResponseDTO);

    List<DetailResponseDTO> findAll();

    DetailResponseDTO findDetailById(Long idClientDetail);

    void delete(Long IdClientDetail);
}
