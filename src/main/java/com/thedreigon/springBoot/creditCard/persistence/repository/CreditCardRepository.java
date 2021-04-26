package com.thedreigon.springBoot.creditCard.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thedreigon.springBoot.creditCard.persistence.model.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

    /**
    Optional<CreditCard> findByCreditCardNumber(long creditCardNumber);
     */
}