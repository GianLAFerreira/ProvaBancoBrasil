package br.com.bb.utils.validation;

import br.com.bb.entity.PaymentEntity;

public interface PaymentValidation {

    boolean isValid(PaymentEntity paymentEntity);
}
