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
        description = "Representa los datos necesarios para la Direccion del cliente"
)
public class DirectionsRequestDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. street is required.")
    @NotNull
    private String street;

    @ApiModelProperty(position = 2, notes = "Non negative value. number is required.")
    @NotNull
    private String number;

    @ApiModelProperty(position = 3, notes = "Non negative value. flat is required.")
    @NotNull
    private String flat;

    @ApiModelProperty(position = 4, notes = "Non negative value. postal code is required.")
    @NotNull
    private String postalCode;

    @ApiModelProperty(position = 5, notes = "Non negative value. location is required.")
    @NotNull
    private String location;

    @ApiModelProperty(position = 6, notes = "Non negative value. city is required.")
    @NotNull
    private String city;

    @ApiModelProperty(position = 7, notes = "Non negative value. country is required.")
    @NotNull
    private String country;

}
