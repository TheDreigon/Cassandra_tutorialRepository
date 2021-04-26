package com.thedreigon.springBoot.creditCard.converter;

import com.thedreigon.springBoot.creditCard.command.CreditCardCreateDto;
import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreditCardCreateDtoToNewCreditCard {

    public CreditCard convert(CreditCardCreateDto creditCardCreateDto) {

        CreditCard newCreditCard = new CreditCard();

        newCreditCard.setCreditCardNumber(creditCardCreateDto.getCreditCardNumber());
        newCreditCard.setFirstName(creditCardCreateDto.getFirstName());
        newCreditCard.setLastName(creditCardCreateDto.getLastName());
        newCreditCard.setAddress(creditCardCreateDto.getAddress());
        newCreditCard.setPhoneNumber(creditCardCreateDto.getPhoneNumber());
        newCreditCard.setExpireDate(creditCardCreateDto.getExpireDate());
        newCreditCard.setCvv(creditCardCreateDto.getCvv());
        newCreditCard.setCreatedDate(LocalDateTime.now());

        return newCreditCard;
    }
}
