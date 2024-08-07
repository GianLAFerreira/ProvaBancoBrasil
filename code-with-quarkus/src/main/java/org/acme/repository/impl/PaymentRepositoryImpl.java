package org.acme.repository.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Payment;

@ApplicationScoped
public class PaymentRepositoryImpl implements PanacheRepository<Payment> {
}
