package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.Payment;
import org.acme.repository.impl.PaymentRepositoryImpl;

import java.util.List;

@ApplicationScoped
public class PaymentService {

    @Inject
    PaymentRepositoryImpl repository;

    public List<Payment> findAllPayments(){
        return  repository.findAll().list();
    }

    @Transactional
    public void addPayment(Payment payment){
        repository.persist(payment);
    }
}
