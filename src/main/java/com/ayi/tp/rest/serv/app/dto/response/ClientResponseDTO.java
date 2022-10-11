package com.ayi.tp.rest.serv.app.dto.response;

import com.ayi.tp.rest.serv.app.entity.DetailClient;
import com.ayi.tp.rest.serv.app.entity.Directions;
import com.ayi.tp.rest.serv.app.entity.Invoice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "ClientResponseDTO",
        description = "Representa los datos necesarios para las Clientes creadas"
)
public class ClientResponseDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. ID is required.")
    private Long idClient;

    @ApiModelProperty(position = 2, notes = "Non negative value. name is required.")
    private String name;

    @ApiModelProperty(position = 3, notes = "Non negative value. last name is required.")
    private String lastName;

    @ApiModelProperty(position = 4, notes = "Non negative value. dni is required.")
    private String dni;

    @JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 5, notes = "Non negative value. dni is required.")
    private DetailResponseDTO detailClient;

    @JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 6, notes = "Non negative value. dni is required.")
    private List<DirectionsResponseDTO> directions;

    @JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 7, notes = "Non negative value. dni is required.")
    private List<InvoiceResponseDTO> invoice;
}
