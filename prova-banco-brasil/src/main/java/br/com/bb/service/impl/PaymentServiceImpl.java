package br.com.bb.service.impl;

import br.com.bb.entity.PaymentEntity;
import br.com.bb.repository.PaymentRepository;
import br.com.bb.service.PaymentService;
import br.com.bb.utils.validation.PaymentValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import java.util.List;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService {

    @Inject
    PaymentRepository repository;
    @Inject
    PaymentValidation validation;

    public List<PaymentEntity> findAllPayments(){
        return  repository.findAll().list();
    }

    public PaymentEntity findPaymentById(long id){
        return repository.findById(id);
    }

    @Transactional
    public void addPayment(PaymentEntity paymentEntity){
        try {
            validation.isValid(paymentEntity);
            repository.persist(paymentEntity);
        } catch (BadRequestException e){
            throw e;
        }
    }
}
