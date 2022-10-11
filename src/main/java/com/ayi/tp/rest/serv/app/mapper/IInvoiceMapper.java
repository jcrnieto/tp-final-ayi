package com.ayi.tp.rest.serv.app.mapper;

import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Invoice;

public interface IInvoiceMapper {

    InvoiceResponseDTO entityToDto(Invoice entity);

    Invoice dtoToEntity(InvoiceResponseDTO dto);

    Invoice toEntityByRequest(InvoiceResponseDTO dto);
}
