package com.ayi.tp.rest.serv.app.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
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
public class InvoiceRequestDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. descriptions invoice is required.")
    @NotNull
    private String descriptionInvoice;

    @ApiModelProperty(position = 2, notes = "Non negative value. total is required.")
    @NotNull
    private Double total;
}
