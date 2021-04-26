package com.thedreigon.springBoot.creditCard.command;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreditCardCreateDto {

    @NotNull
    @ApiModelProperty(notes = "Credit Card number")
    private long creditCardNumber;

    @NotNull
    @ApiModelProperty(notes = "First name")
    private String firstName;

    @NotNull
    @ApiModelProperty(notes = "Last name")
    private String lastName;

    @NotNull
    @ApiModelProperty(notes = "Address")
    private String address;

    @NotNull
    @ApiModelProperty(notes = "Phone number")
    private String phoneNumber;

    @NotNull
    @ApiModelProperty(notes = "Expiration date")
    private String expireDate;

    @NotNull
    @ApiModelProperty(notes = "Card Verification Value")
    private String cvv;

    /**
     * @return the creditCardNumber
     */
    public long getCreditCardNumber() {
        return this.creditCardNumber;
    }

    /**
     * @param creditCardNumber the creditCardNumber to set
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

    @Override
    public String toString() {
        return "CreditCardCreateDto{" +
                "creditCardNumber=" + creditCardNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
