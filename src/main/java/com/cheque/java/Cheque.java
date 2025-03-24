package com.cheque.java;
import com.payment.java.Payment;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class Cheque extends Payment {
    
    private String chequeNumber;

    // Constructors
    public Cheque() {}

    public Cheque(double amount, String chequeNumber) {
        super(amount);
        this.chequeNumber = chequeNumber;
    }

    // Getters & Setters
    public String getChequeNumber() { return chequeNumber; }
    public void setChequeNumber(String chequeNumber) { this.chequeNumber = chequeNumber; }
}



