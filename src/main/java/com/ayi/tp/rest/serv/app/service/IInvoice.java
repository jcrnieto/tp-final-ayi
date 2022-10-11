package com.ayi.tp.rest.serv.app.service;

import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;

import java.util.List;

public interface IInvoice {

    InvoiceResponseDTO saveInvoice(InvoiceResponseDTO invoiceResponseDTO);

    List<InvoiceResponseDTO> findAll();

    InvoiceResponseDTO findInvoiceById(Long idInvoice);

    void delete(Long idInvoice);
}
