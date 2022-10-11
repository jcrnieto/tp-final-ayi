package com.ayi.tp.rest.serv.app.service;


import com.ayi.tp.rest.serv.app.dto.request.ClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.exception.ReadAccesException;

import java.util.List;

public interface IClientService {

    ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO saveClient(Long idClient, ClientRequestDTO request);

    List<ClientResponseDTO> findAll() throws ReadAccesException;

    ClientResponseDTO findClientById(Long idClient) throws ReadAccesException;

    void delete(Long idClient);

    ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO);

}
