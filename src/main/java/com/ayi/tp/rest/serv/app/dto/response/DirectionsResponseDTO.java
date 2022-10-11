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
        description = "Representa los datos necesarios para la Direccion del cliente"
)
public class DirectionsResponseDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. ID is required.")
    private Long idDirections;

    @ApiModelProperty(position = 2, notes = "Non negative value. street is required.")
    private String street;

    @ApiModelProperty(position = 3, notes = "Non negative value. number is required.")
    private String number;

    @ApiModelProperty(position = 3, notes = "Non negative value. flat is required.")
    private String flat;

    @ApiModelProperty(position = 4, notes = "Non negative value. postal code is required.")
    private String postalCode;

    @ApiModelProperty(position = 5, notes = "Non negative value. location is required.")
    private String location;

    @ApiModelProperty(position = 6, notes = "Non negative value. city is required.")
    private String city;

    @ApiModelProperty(position = 7, notes = "Non negative value. country is required.")
    private String country;

    @JsonIgnoreProperties(value = "directions")
    @ApiModelProperty(position = 8, notes = "Non negative value. country is required.")
    private ClientResponseDTO client;

}
