package io.github.tainafernandes.paymentservice.service.impl;

import io.github.tainafernandes.paymentservice.model.Payment;
import io.github.tainafernandes.paymentservice.service.PaymentService;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}", payment);
        Thread.sleep(1000);

        log.info("Enviando pagamento...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
