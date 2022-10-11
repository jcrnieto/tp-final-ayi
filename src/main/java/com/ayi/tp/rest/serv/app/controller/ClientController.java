package com.ayi.tp.rest.serv.app.controller;

import com.ayi.tp.rest.serv.app.dto.request.ClientRequestDTO;
import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.exception.ReadAccesException;
import com.ayi.tp.rest.serv.app.service.IClientService;
import com.ayi.tp.rest.serv.app.service.impl.ClientServiceImpl;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Api(value = "Client Api", tags = {"Client Service"})
@RestController
@RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class ClientController {

    private IClientService clientService;


    @PutMapping(value = "/updateClient/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value ="Save a client and return it.",
            httpMethod = "PUT",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "CREATED - Client was successfully created",
                    response = ClientResponseDTO.class),
            @ApiResponse(code = 400,
                    message = "INVALID_ARGUMENT - Certain arguments "
                            + "cannot be empty or null.")
    })

    public ResponseEntity<ClientResponseDTO> updateClient(
            @ApiParam(value = "id of person to update", required = true, example = "1")
            @PathVariable(name = "id") Long idClient,
            @ApiParam(value = "data of person", required = true)
            @RequestBody ClientRequestDTO request)
    {
        ClientResponseDTO clientResponseDTO = clientService.saveClient(idClient, request);
        return ResponseEntity.ok(clientResponseDTO);
    }


    @GetMapping(value = "/getAllClient")
    @ApiOperation(
            value = "Retrieves List of all Client",
            httpMethod = "GET",
            response = ClientResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about persons",
                    response = ClientResponseDTO[].class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<?> getAllClient() {

        List<ClientResponseDTO> personResponseDTOs = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personResponseDTOs = clientService.findAll();
        } catch (ReadAccesException e) {
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(personResponseDTOs);
    }



    @GetMapping(value = "/getClientById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to Master List by Id",
            httpMethod = "GET",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with basic information for Master List  by Id"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc."),
            @ApiResponse(code = 404, message = "Person not found")
    })
    public  ResponseEntity<?> getClientById(
            @ApiParam(name = "id", required = true, value = "Person Id", example = "1")
            @PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(clientService.findClientById(id));
        } catch (ReadAccesException e) {
            response.put("Código de error", 404);
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a client by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Person deleted by id"),
            @ApiResponse(code = 404, message = "Person not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deletePerson(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable Long id){
        clientService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping(value = "/addClient", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value ="Save a person and return it.",
            httpMethod = "POST",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "CREATED - Person was successfully created",
                    response = ClientResponseDTO.class),
            @ApiResponse(code = 400,
                    message = "INVALID_ARGUMENT - Certain arguments "
                            + "cannot be empty or null.")
    })

    public ResponseEntity<ClientResponseDTO> addClient(
            @ApiParam(name = "Client", required = true, value = "add client", example = "1")
            @RequestBody ClientRequestDTO client) {
        return new ResponseEntity<>(clientService.addClient(client),HttpStatus.CREATED);
    }
}
