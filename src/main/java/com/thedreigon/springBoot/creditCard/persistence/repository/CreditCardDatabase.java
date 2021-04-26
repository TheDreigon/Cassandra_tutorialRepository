package com.thedreigon.springBoot.creditCard.persistence.repository;

import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CreditCardDatabase {

    private final HashMap<Long, CreditCard> creditCardDBList = new HashMap<>();

    public HashMap<Long, CreditCard> getCreditCardDBList() {
        return creditCardDBList;
    }
}
