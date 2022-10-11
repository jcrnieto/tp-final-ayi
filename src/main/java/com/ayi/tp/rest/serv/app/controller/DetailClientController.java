package com.ayi.tp.rest.serv.app.controller;

import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.DetailResponseDTO;
import com.ayi.tp.rest.serv.app.service.IClientService;
import com.ayi.tp.rest.serv.app.service.IDetailClientService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Api(value = "Detail Client Api", tags = {"Detail Client Service"})
@RestController
@RequestMapping(value = "/detailClient", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class DetailClientController {

    private IDetailClientService detailClientService;

    @GetMapping(value = "/getAllDetailClient")
    @ApiOperation(
            value = "Retrieves List of all Detail client",
            httpMethod = "GET",
            response = DetailResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about detail client",
                    response = DetailResponseDTO[].class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<List<DetailResponseDTO>> getAllClient() {

        List<DetailResponseDTO> clientResponseDTOs = detailClientService.findAll();
        return ResponseEntity.ok(clientResponseDTOs);
    }



    @GetMapping(
            value = "/getDetailClientById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to Master List by Id",
            httpMethod = "GET",
            response = DetailResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with basic information for Master List  by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<DetailResponseDTO> getClientById(
            @ApiParam(name = "id", required = true, value = "Detail client Id", example = "1")
            @PathVariable("id") Long id){

        return ResponseEntity.ok(detailClientService.findDetailById(id));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a detail client by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Detail deleted by id"),
            @ApiResponse(code = 404, message = "Detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deletePerson(
            @ApiParam(name = "id", required = true, value = "Detail Client Id", example = "1")
            @PathVariable Long id){
        detailClientService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
