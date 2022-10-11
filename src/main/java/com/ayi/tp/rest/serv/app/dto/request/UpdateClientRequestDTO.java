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
        value = "UpdateClientRequestDTO",
        description = "Representa los datos necesarios para las Clientes creadas"
)
public class UpdateClientRequestDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. name is required.")
    @NotNull
    private String name;

    @ApiModelProperty(position = 2, notes = "Non negative value. last name is required.")
    @NotNull
    private String lastName;

    @ApiModelProperty(position = 3, notes = "Non negative value. dni is required.")
    @NotNull
    private String dni;
}
