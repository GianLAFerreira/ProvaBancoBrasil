package br.com.bb.service;

import br.com.bb.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> findAllPayments();
    PaymentEntity findPaymentById(long id);
    void addPayment(PaymentEntity paymentEntity);
}
