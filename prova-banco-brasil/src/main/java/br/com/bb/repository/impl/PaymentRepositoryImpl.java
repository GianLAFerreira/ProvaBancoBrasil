package br.com.bb.repository.impl;

import br.com.bb.entity.PaymentEntity;
import br.com.bb.repository.PaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class PaymentRepositoryImpl implements PaymentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public PaymentEntity findByPaymentId(String paymentId) {
        try {
            return em.createQuery("SELECT p FROM PaymentEntity p WHERE p.paymentId = :paymentId", PaymentEntity.class)
                    .setParameter("paymentId", paymentId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
