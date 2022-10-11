package com.ayi.tp.rest.serv.app.controller;


import com.ayi.tp.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.DirectionsResponseDTO;
import com.ayi.tp.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.tp.rest.serv.app.service.IInvoice;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Api(value = "Invoice Api", tags = {"Invoice Service"})
@RestController
@RequestMapping(value = "/Invoice", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class InvoiceController {

    private IInvoice invoiceService;

    @GetMapping(value = "/getAllInvoice")
    @ApiOperation(
            value = "Retrieves List of all Invoice",
            httpMethod = "GET",
            response = InvoiceResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Body content with basic information about persons",
                    response = InvoiceResponseDTO[].class),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data formats, etc.")
    })
    public ResponseEntity<List<InvoiceResponseDTO>> getAllClient() {

        List<InvoiceResponseDTO> invoiceResponseDTOs = invoiceService.findAll();
        return ResponseEntity.ok(invoiceResponseDTOs);
    }


    @GetMapping(
            value = "/getDirectionById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to Master List by Id",
            httpMethod = "GET",
            response = InvoiceResponseDTO.class
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
    public ResponseEntity<InvoiceResponseDTO> getClientById(
            @ApiParam(name = "id", required = true, value = "Direction Id", example = "1")
            @PathVariable("id") Long id){

        return ResponseEntity.ok(invoiceService.findInvoiceById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a invoice by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Invoice deleted by id"),
            @ApiResponse(code = 404, message = "Invoice not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteInvoice(
            @ApiParam(name = "id", required = true, value = "Invoice Id", example = "1")
            @PathVariable Long id){
        invoiceService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
