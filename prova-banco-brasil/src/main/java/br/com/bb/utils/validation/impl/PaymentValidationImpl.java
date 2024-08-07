package br.com.bb.utils.validation.impl;

import br.com.bb.entity.PaymentEntity;
import br.com.bb.repository.PaymentRepository;
import br.com.bb.utils.validation.PaymentValidation;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.BadRequestException;

@Singleton
public class PaymentValidationImpl implements PaymentValidation {
    @Inject
    PaymentRepository repository;

    @Override
    public boolean isValid(PaymentEntity paymentEntity) {
        validAmount(paymentEntity);
        validCurrency(paymentEntity);
        validEmail(paymentEntity);
        validCardNumber(paymentEntity);
        validCardCVC(paymentEntity);
        validPayerName(paymentEntity);
        validPaymentMethod(paymentEntity);
        validTransactionDate(paymentEntity);
        validDescription(paymentEntity);
        validPaymentID(paymentEntity);

        return true;
    }

    private void validPaymentID(PaymentEntity paymentEntity) {
        PaymentEntity paymentEntityBanco = repository.findByPaymentId(paymentEntity.getPaymentId());

        if (paymentEntityBanco != null) {
            throw new BadRequestException("Existing paymentId.");
        }
    }

    private void validAmount(PaymentEntity paymentEntity) {
        if (paymentEntity.getAmount() <= 0) {
            throw new BadRequestException("Amount must be greater than zero.");
        }
    }

    private void validCurrency(PaymentEntity paymentEntity) {
        String currency = paymentEntity.getCurrency();
        if (currency == null || !currency.matches("^[A-Z]{3}$")) {
            throw new BadRequestException("Currency must be a valid ISO 4217 code.");
        }
    }

    private void validEmail(PaymentEntity paymentEntity) {
        String email = paymentEntity.getPayerEmail();
        if (email == null || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new BadRequestException("Email must be valid.");
        }
    }

    private void validCardNumber(PaymentEntity paymentEntity) {
        String cardNumber = paymentEntity.getCardNumber();
        if (cardNumber == null || !cardNumber.matches("^\\d{13,19}$")) {
            throw new BadRequestException("Card number must be between 13 to 19 digits.");
        }
    }

    private void validCardCVC(PaymentEntity paymentEntity) {
        String cardCvc = paymentEntity.getCardCvc();
        if (cardCvc == null || !cardCvc.matches("^\\d{3,4}$")) {
            throw new BadRequestException("CVC must be 3 or 4 digits.");
        }
    }

    private void validPayerName(PaymentEntity paymentEntity) {
        String payerName = paymentEntity.getPayerName();
        if (payerName == null || payerName.trim().isEmpty()) {
            throw new BadRequestException("Payer name must not be empty.");
        }
    }

    private void validPaymentMethod(PaymentEntity paymentEntity) {
        String paymentMethod = paymentEntity.getPaymentMethod();
        if (paymentMethod == null || !(paymentMethod.equals("credit_card") || paymentMethod.equals("debit_card") || paymentMethod.equals("paypal"))) {
            throw new BadRequestException("Payment method must be valid.");
        }
    }

    private void validTransactionDate(PaymentEntity paymentEntity) {
        if (paymentEntity.getTransactionDate() == null) {
            throw new BadRequestException("Transaction date must be provided.");
        }
    }

    private void validDescription(PaymentEntity paymentEntity) {
        String description = paymentEntity.getDescription();
        if (description != null && description.length() > 255) {
            throw new BadRequestException("Description must not exceed 255 characters.");
        }
    }
}
