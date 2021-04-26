package com.thedreigon.springBoot.creditCard.converter;

import com.thedreigon.springBoot.creditCard.command.CreditCardGetDto;
import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardToCreditCardGetDtoConverter {


    public CreditCardGetDto convert(CreditCard creditCard) {

        CreditCardGetDto creditCardGetDto = new CreditCardGetDto();

        creditCardGetDto.setId(creditCard.getId());
        creditCardGetDto.setCreditCardNumber(creditCard.getCreditCardNumber());
        creditCardGetDto.setFirstName(creditCard.getFirstName());
        creditCardGetDto.setLastName(creditCard.getLastName());
        creditCardGetDto.setAddress(creditCard.getAddress());
        creditCardGetDto.setPhoneNumber(creditCard.getPhoneNumber());
        creditCardGetDto.setExpireDate(creditCard.getExpireDate());
        creditCardGetDto.setCvv(creditCard.getCvv());
        creditCardGetDto.setCreatedDate(creditCard.getCreatedDate());
        creditCardGetDto.setExpireDate(creditCard.getExpireDate());

        return creditCardGetDto;
    }
}
