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
        value = "DetailResponseDTO",
        description = "Representa los datos necesarios para los detalles del cliente"
)
public class DetailResponseDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. ID is required.")
    private Long idClientDetail;

    @ApiModelProperty(position = 2, notes = "Non negative value. vip is required.")
    private Boolean vip;

    @ApiModelProperty(position = 3, notes = "Non negative value. points is required.")
    private Integer points;

    @JsonIgnoreProperties(value = "detailClient")
    @ApiModelProperty(position = 4, notes = "Non negative value. points is required.")
    private ClientResponseDTO client;


}
