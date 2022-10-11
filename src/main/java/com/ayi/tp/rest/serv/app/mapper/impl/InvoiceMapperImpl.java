package com.ayi.tp.rest.serv.app.mapper.impl;

import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Invoice;
import com.ayi.tp.rest.serv.app.mapper.IInvoiceMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceMapperImpl implements IInvoiceMapper {

    private final ModelMapper modelMapper;



    @Override
    public InvoiceResponseDTO entityToDto(Invoice entity) {
        return modelMapper.map(entity, InvoiceResponseDTO.class );
    }

    @Override
    public Invoice dtoToEntity(InvoiceResponseDTO dto) {
        return modelMapper.map(dto, Invoice.class);
    }

    @Override
    public Invoice toEntityByRequest(InvoiceResponseDTO dto) {
        Invoice personEntity = new Invoice();
        modelMapper.map(dto, personEntity);
        return personEntity;
    }
}
