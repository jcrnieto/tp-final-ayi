package com.ayi.tp.rest.serv.app.service.impl;

import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.tp.rest.serv.app.entity.Invoice;
import com.ayi.tp.rest.serv.app.mapper.IInvoiceMapper;
import com.ayi.tp.rest.serv.app.repository.IInvoiceRepository;
import com.ayi.tp.rest.serv.app.service.IInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements IInvoice {
    @Autowired
    private IInvoiceRepository invoiceRepository;
    @Autowired
    private IInvoiceMapper invoiceMapper;
    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceResponseDTO invoiceResponseDTO) {

        Invoice invoice = invoiceRepository.save(invoiceMapper.dtoToEntity(invoiceResponseDTO));
        return invoiceMapper.entityToDto(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> findAll() {

        List<InvoiceResponseDTO> invoiceResponseDTOS;

        List<Invoice> invoices = invoiceRepository.findAll();

        invoiceResponseDTOS = invoices.stream().map(invoice -> invoiceMapper.entityToDto(invoice))
                .collect(Collectors.toList());
        return invoiceResponseDTOS;
    }

    @Override
    public InvoiceResponseDTO findInvoiceById(Long idInvoice) {

        InvoiceResponseDTO invoiceResponseDTO;

        Optional<Invoice> entity = invoiceRepository.findById(idInvoice);

        invoiceResponseDTO = invoiceMapper.entityToDto(entity.get());

        return invoiceResponseDTO;
    }

    @Override
    public void delete(Long idInvoice) {

        Optional<Invoice> invoice = invoiceRepository.findById(idInvoice);

        if(invoice.isPresent()){
            invoiceRepository.deleteById(idInvoice);
        }else {
            throw new RuntimeException("Error. ID not found.");
        }

    }
}
