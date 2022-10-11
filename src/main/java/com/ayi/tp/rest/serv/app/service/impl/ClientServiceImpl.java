package com.ayi.tp.rest.serv.app.service.impl;

import com.ayi.tp.rest.serv.app.dto.request.ClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.request.UpdateClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Client;
import com.ayi.tp.rest.serv.app.exception.ReadAccesException;
import com.ayi.tp.rest.serv.app.mapper.IClientMapper;
import com.ayi.tp.rest.serv.app.mapper.IDetailClientMapper;
import com.ayi.tp.rest.serv.app.repository.IClientRepository;
import com.ayi.tp.rest.serv.app.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClientServiceImpl extends Exception implements IClientService {

    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private IClientMapper clientMapper;

    private IDetailClientMapper detailClientMapper;


    @Override
    public ClientResponseDTO saveClient(Long idClient, ClientRequestDTO request) {
        return null;
    }

    @Override
    public ClientResponseDTO saveClient(Long idClient, UpdateClientRequestDTO request) {
       Optional<Client> client = clientRepository.findById(idClient);

       Client updateClient = client.get();

       if(client.isPresent()){
           updateClient.setName(request.getName());
           updateClient.setLastName(request.getLastName());
           updateClient.setDni(request.getDni());

           clientRepository.save(updateClient);
           return clientMapper.entityToDto(updateClient);
       }else{
           throw new RuntimeException("No se encuentra el ID a actualizar");
       }
    }




    @Override
    public List<ClientResponseDTO> findAll() throws ReadAccesException {

        List<ClientResponseDTO> clientResponseDTOS;

        List<Client> clientList = clientRepository.findAll();

        if(clientList == null || clientList.size() == 0){
            throw new ReadAccesException("no existen clientes registrados");
        }


        clientResponseDTOS = clientList.stream()
                .map(client -> clientMapper.entityToDto(client))
                .collect(Collectors.toList());
        return clientResponseDTOS;
    }

    @Override
    public ClientResponseDTO findClientById (Long idClient) throws ReadAccesException {

        if(idClient == null || idClient < 0){
            throw new ReadAccesException("el id es nulo o vacio");
        }

        ClientResponseDTO clientResponseDTO;

        Optional<Client> entity = clientRepository.findById(idClient);



        clientResponseDTO = clientMapper.entityToDto(entity.get());
        return clientResponseDTO;
    }


    @Override
    public void delete(Long idClient) {

        Optional<Client> client = clientRepository.findById(idClient);

          if(client.isPresent()){
              clientRepository.deleteById(idClient);
          }else {
              throw new RuntimeException("Error. ID not found.");
          }

    }

    @Override
    public ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.dtoToEntity(clientRequestDTO);

        clientRepository.save(client);

        return clientMapper.entityToDto(client);

    }


}
