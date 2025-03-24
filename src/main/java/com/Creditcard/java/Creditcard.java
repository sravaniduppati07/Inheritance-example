package com.Creditcard.java;
import com.payment.java.Payment;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CREDIT_CARD")
public class Creditcard extends Payment {
    
    private String cardNumber;

    // Constructors
    public Creditcard() {}

    public Creditcard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    // Getters & Setters
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    
}