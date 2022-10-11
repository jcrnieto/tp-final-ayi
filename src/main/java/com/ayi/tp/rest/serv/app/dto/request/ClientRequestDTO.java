package com.ayi.tp.rest.serv.app.dto.request;

import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
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
public class ClientRequestDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. name is required.")
    @NotNull
    private String name;

    @ApiModelProperty(position = 2, notes = "Non negative value. last name is required.")
    @NotNull
    private String lastName;

    @ApiModelProperty(position = 3, notes = "Non negative value. dni is required.")
    @NotNull
    private String dni;

    //@JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 4, notes = "Non negative value. dni is required.")
    private DetailClientRequestDTO detailClient;

   // @JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 5, notes = "Non negative value. dni is required.")
    private List<DirectionsRequestDTO> directions;

    //@JsonIgnoreProperties(value = "client")
    @ApiModelProperty(position = 6, notes = "Non negative value. dni is required.")
    private List<InvoiceRequestDTO> invoice;
}
