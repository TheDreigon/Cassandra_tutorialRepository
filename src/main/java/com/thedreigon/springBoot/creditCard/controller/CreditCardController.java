package com.thedreigon.springBoot.creditCard.controller;

import javax.validation.Valid;

import com.thedreigon.springBoot.creditCard.exceptions.CreditCardException;
import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;
import com.thedreigon.springBoot.creditCard.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thedreigon.springBoot.creditCard.command.CreditCardCreateDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardEditableAttributesDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardGetDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;

import java.util.List;

@RestController
@RequestMapping("/api/springboot/visa/electron")
@Api(value = "Credit Card API")
public class CreditCardController {

    private CreditCardService creditCardService;

    /**
     * Sets the CreditCard service.
     *
     */
    @Autowired
    public void setCreditCardServiceImpl(final CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    /**
     * POST request to create a credit card
     *
     * @return CreditCardCreateDto
     */
    @ApiOperation(value = "Create Visa Electron Card", response = CreditCardGetDto.class)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Successful credit card creation"),
            @ApiResponse(code = 400, message = "Invalid attribute on the payload"),
            @ApiResponse(code = 422, message = "The credit card number is already on the database") })
    public ResponseEntity<CreditCard> createCreditCard(@Valid @RequestBody final CreditCardCreateDto creditCardCreateDto) {

        return new ResponseEntity<>(this.creditCardService.createCreditCard(creditCardCreateDto), HttpStatus.OK);
    }

    /**
     * GET request to retrieve a representation of the credit card list
     *
     * @return CreditCardGetDto
     */
    @ApiOperation(value = "Get Visa Electron Card information", response = CreditCardGetDto.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = {"/", "", "/list"})
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful credit card list retrieval"),
            @ApiResponse(code = 404, message = "Credit card not found") })
    public ResponseEntity<List<CreditCardGetDto>> getCreditCardList() {

        return new ResponseEntity<>(this.creditCardService.getCreditCardList(), HttpStatus.OK);
    }

    /**
     * GET request to retrieve a representation of a given credit card
     *
     * @return CreditCardGetDto
     */
    @ApiOperation(value = "Get Visa Electron Card information", response = CreditCardGetDto.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{creditCardId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful credit card retrieval"),
            @ApiResponse(code = 404, message = "Credit card not found") })
    public ResponseEntity<CreditCardGetDto> getCreditCard(@PathVariable @NonNull final Long creditCardId) {

        try {
            return new ResponseEntity<>(this.creditCardService.getCreditCard(creditCardId), HttpStatus.OK);

        } catch (CreditCardException e) {
            System.out.println("Credit card not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * PUT request to update a credit card
     *
     * @return CreditCardGetDto
     */
    @ApiOperation(value = "Edit Visa Electron Card", response = CreditCardGetDto.class)
    @PutMapping(path = "/{creditCardId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful credit card update"),
            @ApiResponse(code = 400, message = "Invalid attribute on the payload"),
            @ApiResponse(code = 404, message = "Credit card not found") })
    public ResponseEntity<CreditCard> editCreditCard(
            @PathVariable @NonNull final Long creditCardId,
            @Valid @RequestBody final CreditCardEditableAttributesDto creditCardEditableAttributesDto) {

        try {
            return new ResponseEntity<>(this.creditCardService.editCreditCard(creditCardId, creditCardEditableAttributesDto), HttpStatus.OK);

        } catch (CreditCardException e) {
            System.out.println("Credit card not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE request to delete a credit card
     *
     * @return CreditCardGetDto
     */
    @ApiOperation(value = "Delete Visa Electron Card")
    @DeleteMapping(path = "/{creditCardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Successful credit card deletion"),
            @ApiResponse(code = 404, message = "Credit card not found") })
    public ResponseEntity<CreditCardGetDto> deleteCreditCard(@PathVariable @NonNull final Long creditCardId) {

        try {
            this.creditCardService.deleteCreditCard(creditCardId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CreditCardException e) {
            System.out.println("Credit card not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
