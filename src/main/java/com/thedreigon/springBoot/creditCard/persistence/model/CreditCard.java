package com.thedreigon.springBoot.creditCard.persistence.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "Credit card")
@ApiModel(value = "Credit card entity properties")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Credit Card Id")
    private long id;

    @NotNull
    @ApiModelProperty(notes = "Credit card number")
    @Column(name = "credit_card_number", nullable = false, length = 16, unique = true)
    private long creditCardNumber;

    @NotNull
    @ApiModelProperty(notes = "First name")
    @Column(name = "first_name", length = 16, nullable = false)
    private String firstName;

    @NotNull
    @ApiModelProperty(notes = "Last name")
    @Column(name = "last_name", length = 16, nullable = false)
    private String lastName;

    @ApiModelProperty(notes = "Address")
    @Column(name = "address")
    private String address;

    @ApiModelProperty(notes = "Phone number")
    @Column(name = "phone_number", length = 64)
    private String phoneNumber;

    @NotNull
    @ApiModelProperty(notes = "Expiration date")
    private String expireDate;

    @NotNull
    @ApiModelProperty(notes = "Card Verification Value")
    @Column(name = "cvv", length = 3, nullable = false)
    private String cvv;

    @NotNull
    @ApiModelProperty(notes = "Entry creation date")
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createdDate;

    @ApiModelProperty(notes = "Last entry update date")
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    /**
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the cardNumber
     */
    public long getCreditCardNumber() {
        return this.creditCardNumber;
    }

    /**
     * @param creditCardNumber the cardNumber to set
     */
    public void setCreditCardNumber(final long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the expireDate
     */
    public String getExpireDate() {
        return this.expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(final String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return this.cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(final String cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the createDate
     */
    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    /**
     * @param createdDate the createDate to set
     */
    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(final LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
