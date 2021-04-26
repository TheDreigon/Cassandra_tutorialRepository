package com.thedreigon.springBoot.creditCard.services;

import com.thedreigon.springBoot.creditCard.command.CreditCardCreateDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardEditableAttributesDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardGetDto;
import com.thedreigon.springBoot.creditCard.exceptions.CreditCardException;
import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;

import java.util.List;

public interface CreditCardService {

    //CREATE
    CreditCard createCreditCard(CreditCardCreateDto creditCardCreateDto);

    //READ ALL
    List<CreditCardGetDto> getCreditCardList();

    //READ
    CreditCardGetDto getCreditCard(long id)
            throws CreditCardException;

    //UPDATE
    CreditCard editCreditCard(long id, CreditCardEditableAttributesDto creditCardEditableAttributesDto)
            throws CreditCardException;

    //DELETE
    void deleteCreditCard(long id)
            throws CreditCardException;
}
