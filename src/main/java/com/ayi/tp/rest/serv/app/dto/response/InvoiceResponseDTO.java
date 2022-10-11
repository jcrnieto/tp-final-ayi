package com.ayi.tp.rest.serv.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "PersonResponseDTO",
        description = "Representa los datos necesarios para la factura del cliente"
)

public class InvoiceResponseDTO implements Serializable {
    @ApiModelProperty(position = 1, notes = "Non negative value. ID is required.")
    private Long idDescription;

    @ApiModelProperty(position = 2, notes = "Non negative value. descriptions invoice is required.")
    private String descriptionInvoice;

    @ApiModelProperty(position = 3, notes = "Non negative value. total is required.")
    private Double total;

    @JsonIgnoreProperties(value = "invoice")
    @ApiModelProperty(position = 4, notes = "Non negative value. total is required.")
    private ClientResponseDTO client;
}
