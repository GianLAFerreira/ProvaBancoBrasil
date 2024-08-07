package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private String paymentId;
    private double amount;
    private String currency;
    private String payerName;
    private String payerEmail;
    private String paymentMethod;
    private String cardNumber;
    private String cardExpiry;
    private String cardCvc;
    private String description;
    private LocalDateTime transactionDate;
}
