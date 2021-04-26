package com.thedreigon.springBoot.creditCard.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreditCardGetDto {

    @ApiModelProperty(notes = "Primary Key - ID Number")
    private long id;

    @NotNull
    @ApiModelProperty(notes = "Credit Card number")
    private long creditCardNumber;

    @NotNull
    @ApiModelProperty(notes = "First name")
    private String firstName;

    @NotNull
    @ApiModelProperty(notes = "Last name")
    private String lastName;

    @ApiModelProperty(notes = "Address")
    private String address;

    @ApiModelProperty(notes = "Phone number")
    private String phoneNumber;

    @NotNull
    @ApiModelProperty(notes = "Expiration date")
    private String expireDate;

    @NotNull
    @ApiModelProperty(notes = "Card Verification Value")
    private String cvv;

    @NotNull
    @ApiModelProperty(notes = "Entry creation date")
    private LocalDateTime createdDate;

    @ApiModelProperty(notes = "Last entry update date")
    private LocalDateTime updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "CreditCardGetDto{" +
                "id=" + id +
                ", creditCardNumber=" + creditCardNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updateDate +
                '}';
    }
}
