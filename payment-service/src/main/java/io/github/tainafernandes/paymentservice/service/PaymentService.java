package io.github.tainafernandes.paymentservice.service;

import io.github.tainafernandes.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
