package com.ayi.tp.rest.serv.app.controller;


import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.service.IDirections;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Api(value = "Directions Api", tags = {"Directions Service"})
@RestController
@RequestMapping(value = "/directions", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class DirectionController {

    private IDirections directionService;

    @GetMapping(value = "/getAllDirection")
    @ApiOperation(
            value = "Retrieves List of all Direction",
            httpMethod = "GET",
            response = DirectionsResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about direction",
                    response = DirectionsResponseDTO[].class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<List<DirectionsResponseDTO>> getAllClient() {

        List<DirectionsResponseDTO> directionResponseDTOs = directionService.findAll();
        return ResponseEntity.ok(directionResponseDTOs);
    }



    @GetMapping(
            value = "/getDirectionById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to Master List by Id",
            httpMethod = "GET",
            response = DirectionsResponseDTO.class
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
    public ResponseEntity<DirectionsResponseDTO> getClientById(
            @ApiParam(name = "id", required = true, value = "Direction Id", example = "1")
            @PathVariable("id") Long id){

        return ResponseEntity.ok(directionService.findDirectionById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a direction by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Direction deleted by id"),
            @ApiResponse(code = 404, message = "Direction not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deletePerson(
            @ApiParam(name = "id", required = true, value = "Direction Id", example = "1")
            @PathVariable Long id){
        directionService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
