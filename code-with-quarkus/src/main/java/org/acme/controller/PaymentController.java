package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.entity.Payment;
import org.acme.service.PaymentService;

import java.util.ArrayList;
import java.util.List;

@Path("/api/payment")
public class PaymentController {

    @Inject
    PaymentService paymentService;

    @GET
    public List<Payment> retrievePayments() {
        List<Payment> payments = new ArrayList<>();

        try {
            payments = paymentService.findAllPayments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payments;
    }

    @POST
    public void add(Payment payment) {
        paymentService.addPayment(payment);
    }
}
