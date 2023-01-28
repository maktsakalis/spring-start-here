package com.springstarthere.restwithopenfeignservicech11.proxy;

import com.springstarthere.restwithopenfeignservicech11.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments-service", url = "${name.service.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
