package com.springstarthere.restwithwebclientservicech11.proxy;


import com.springstarthere.restwithwebclientservicech11.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class PaymentsProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(Payment payment) {
        return webClient.post().uri(paymentServiceUrl + "/payment").header("requestId", UUID.randomUUID().toString()).body(Mono.just(payment), Payment.class).retrieve().bodyToMono(Payment.class);
    }
}
