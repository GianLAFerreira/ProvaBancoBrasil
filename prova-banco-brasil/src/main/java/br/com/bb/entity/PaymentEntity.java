package br.com.bb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="payment", uniqueConstraints = {@UniqueConstraint(columnNames = "paymentId")})
public class PaymentEntity extends PanacheEntity {

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
