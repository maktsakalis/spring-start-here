package com.springstarthere.restwithwebclientservicech11.controllers;



import com.springstarthere.restwithwebclientservicech11.model.Payment;
import com.springstarthere.restwithwebclientservicech11.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/create-payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
