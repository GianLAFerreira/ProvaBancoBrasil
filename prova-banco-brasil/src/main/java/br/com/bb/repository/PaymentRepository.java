package br.com.bb.repository;

import br.com.bb.entity.PaymentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface PaymentRepository extends PanacheRepository<PaymentEntity> {
    PaymentEntity findByPaymentId(String paymentId);
}
