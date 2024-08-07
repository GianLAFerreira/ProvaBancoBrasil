package br.com.bb.controller;

import br.com.bb.entity.PaymentEntity;
import br.com.bb.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;

import java.util.ArrayList;
import java.util.List;

@Path("/api/payment")
public class PaymentController {

    @Inject
    PaymentService paymentServiceImpl;

    @GET
    @Counted(name = "Contador teste")
    public List<PaymentEntity> retrievePayments() {
        List<PaymentEntity> paymentEntities = new ArrayList<>();

        try {
            paymentEntities = paymentServiceImpl.findAllPayments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentEntities;
    }

    @GET
    @Path("/{id}")
    public Response retrievePayment(@PathParam("id") long id) {
        PaymentEntity paymentEntity = paymentServiceImpl.findPaymentById(id);

        return Response.ok(paymentEntity).build();
    }

    @POST
    public Response add(PaymentEntity paymentEntity) {
        paymentServiceImpl.addPayment(paymentEntity);
        return Response.ok(paymentEntity).build();
    }
}
