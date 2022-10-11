package com.ayi.tp.rest.serv.app.service.impl;

import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Client;
import com.ayi.tp.rest.serv.app.entity.DetailClient;
import com.ayi.tp.rest.serv.app.mapper.IClientMapper;
import com.ayi.tp.rest.serv.app.mapper.IDetailClientMapper;
import com.ayi.tp.rest.serv.app.repository.IClientRepository;
import com.ayi.tp.rest.serv.app.repository.IDetailClientRepository;
import com.ayi.tp.rest.serv.app.service.IDetailClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetailClientServiceImpl implements IDetailClientService {

    @Autowired
    private IDetailClientRepository detailRepository;
    @Autowired
    private IDetailClientMapper detailMapper;
    @Override

    public DetailResponseDTO saveDetailClient(DetailResponseDTO detailResponseDTO) {

        DetailClient detailclient = detailRepository.save(detailMapper.dtoToEntity(detailResponseDTO));
        return detailMapper.entityToDto(detailclient);
    }

    @Override
    public List<DetailResponseDTO> findAll() {

        List<DetailResponseDTO> detailResponseDTOS;

        List<DetailClient> detailClients = detailRepository.findAll();

        detailResponseDTOS = detailClients.stream().map(detailClient -> detailMapper.entityToDto(detailClient))
                .collect(Collectors.toList());
        return detailResponseDTOS;
    }

    @Override
    public DetailResponseDTO findDetailById(Long idClientDetail) {

        DetailResponseDTO detailResponseDTO;

        Optional<DetailClient> entity = detailRepository.findById(idClientDetail);

        detailResponseDTO = detailMapper.entityToDto(entity.get());

        return detailResponseDTO;
    }

    @Override
    public void delete(Long IdClientDetail) {

       Optional<DetailClient> detailClient = detailRepository.findById(IdClientDetail);

        if(detailClient.isPresent()){
            detailRepository.deleteById(IdClientDetail);
        }else {
            throw new RuntimeException("Error. ID not found.");
        }

    }
}
