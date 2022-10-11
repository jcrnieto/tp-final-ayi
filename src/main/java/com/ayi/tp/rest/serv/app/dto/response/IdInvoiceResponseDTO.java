package com.ayi.tp.rest.serv.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

public class IdInvoiceResponseDTO {

    @JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 1, notes = "Non negative value. dni is required.")
    private InvoiceResponseDTO invoiceResponseDTO;

    @ApiModelProperty(position = 2, notes = "Non negative value. dni is required.")
    private  ClientResponseDTO clientResponseDTO;
}
