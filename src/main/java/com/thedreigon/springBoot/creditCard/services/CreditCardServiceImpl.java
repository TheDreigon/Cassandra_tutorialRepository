package com.thedreigon.springBoot.creditCard.services;

import java.util.*;

import com.thedreigon.springBoot.creditCard.aop.CreditCardExceptionHandler;
import com.thedreigon.springBoot.creditCard.converter.CreditCardCreateDtoToNewCreditCard;
import com.thedreigon.springBoot.creditCard.converter.CreditCardToCreditCardGetDtoConverter;
import com.thedreigon.springBoot.creditCard.exceptions.CreditCardException;
import com.thedreigon.springBoot.creditCard.persistence.repository.CreditCardDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thedreigon.springBoot.creditCard.command.CreditCardCreateDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardEditableAttributesDto;
import com.thedreigon.springBoot.creditCard.command.CreditCardGetDto;
import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private int id = 0;
    private CreditCardDatabase creditCardDatabase;
    private CreditCardToCreditCardGetDtoConverter creditCardToCreditCardGetDtoConverter;
    private CreditCardCreateDtoToNewCreditCard creditCardCreateDtoToNewCreditCard;
    private CreditCardExceptionHandler creditCardExceptionHandler;
    //private List<CreditCard> creditCardList;
    private List<CreditCardGetDto> creditCardGetDtoList = new ArrayList<>();

    @Autowired
    public void setCreditCardDatabase(CreditCardDatabase creditCardDatabase) {
        this.creditCardDatabase = creditCardDatabase;
    }

    @Autowired
    public void setCreditCardToCreditCardGetDtoConverter(CreditCardToCreditCardGetDtoConverter creditCardToCreditCardGetDtoConverter) {
        this.creditCardToCreditCardGetDtoConverter = creditCardToCreditCardGetDtoConverter;
    }

    @Autowired
    public void setCreditCardCreateDtoToNewCreditCard(CreditCardCreateDtoToNewCreditCard creditCardCreateDtoToNewCreditCard) {
        this.creditCardCreateDtoToNewCreditCard = creditCardCreateDtoToNewCreditCard;
    }

    @Autowired
    public void setCreditCardExceptionHandler(CreditCardExceptionHandler creditCardExceptionHandler) {
        this.creditCardExceptionHandler = creditCardExceptionHandler;
    }

    /**
     * POST {@inheritDoc}
     */
    @Override
    public CreditCard createCreditCard(final CreditCardCreateDto creditCardCreateDto) {

        System.out.println("POST METHOD CALLED");
        CreditCard newCreditCard = this.creditCardCreateDtoToNewCreditCard.convert(creditCardCreateDto);
        newCreditCard.setId(this.id++);

        this.creditCardDatabase.getCreditCardDBList().put(newCreditCard.getId(), newCreditCard);

        System.out.println(this.creditCardDatabase.getCreditCardDBList().get(newCreditCard.getId()).toString());
        System.out.println("List size: " + this.creditCardDatabase.getCreditCardDBList().size());
        return newCreditCard;
    }

    /**
     * GET ALL {@inheritDoc}
     */
    @Override
    public List<CreditCardGetDto> getCreditCardList() {

        System.out.println("GET ALL METHOD CALLED");

        for (CreditCard creditCard : this.creditCardDatabase.getCreditCardDBList().values()) {
            creditCardGetDtoList.add(creditCardToCreditCardGetDtoConverter.convert(creditCard));
            System.out.println(creditCardToCreditCardGetDtoConverter.convert(creditCard).toString());
        }

        System.out.println("List size: " + this.creditCardDatabase.getCreditCardDBList().size());
        return creditCardGetDtoList;
    }

    /**
     * GET {@inheritDoc}
     */
    @Override
    public CreditCardGetDto getCreditCard(final long creditCardId) throws CreditCardException {

        System.out.println("GET METHOD CALLED");
        creditCardExceptionHandler.checkIfCreditCardExists(creditCardId);

        CreditCard creditCard = this.creditCardDatabase.getCreditCardDBList().get(creditCardId);

        System.out.println(creditCardToCreditCardGetDtoConverter.convert(creditCard).toString());
        return creditCardToCreditCardGetDtoConverter.convert(creditCard);
    }

    /**
     * PUT {@inheritDoc}
     */
    @Override
    public CreditCard editCreditCard(final long creditCardId,
            final CreditCardEditableAttributesDto creditCardEditableAttributesDto)
            throws CreditCardException {

        System.out.println("PUT METHOD CALLED");
        creditCardExceptionHandler.checkIfCreditCardExists(creditCardId);

        CreditCard creditCard = creditCardDatabase.getCreditCardDBList().get(creditCardId);

        creditCard.setFirstName(creditCardEditableAttributesDto.getFirstName());
        creditCard.setLastName(creditCardEditableAttributesDto.getLastName());

        if (creditCardEditableAttributesDto.getAddress() != null) {
            creditCard.setAddress(creditCardEditableAttributesDto.getAddress());
        }
        if (creditCardEditableAttributesDto.getPhoneNumber() != null) {
            creditCard.setPhoneNumber(creditCardEditableAttributesDto.getPhoneNumber());
        }

        System.out.println("Updated credit card: " + creditCard.toString());
        return creditCard;
    }

    /**
     * DELETE {@inheritDoc}
     */
    @Override
    public void deleteCreditCard(final long creditCardId) throws CreditCardException {

        System.out.println("DELETE METHOD CALLED");
        creditCardExceptionHandler.checkIfCreditCardExists(creditCardId);

        System.out.println("List size: " + this.creditCardDatabase.getCreditCardDBList().size());

        creditCardDatabase.getCreditCardDBList().remove(creditCardId);
        System.out.println("Credit card deleted. \nUpdated list size: "  + this.creditCardDatabase.getCreditCardDBList().size());
    }
}
