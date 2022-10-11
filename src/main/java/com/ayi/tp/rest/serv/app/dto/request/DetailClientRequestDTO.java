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
        value = "DetailResponseDTO",
        description = "Representa los datos necesarios para los detalles del cliente"
)
public class DetailClientRequestDTO implements Serializable {

    @ApiModelProperty(position = 1, notes = "Non negative value. vip is required.")
    @NotNull
    private Boolean vip;

    @ApiModelProperty(position = 2, notes = "Non negative value. points is required.")
    @NotNull
    private Integer points;

}
