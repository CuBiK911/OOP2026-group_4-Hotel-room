package org.example;

public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processPayment(payments payment) {
        if (payment.getAmount() <= 0) {
            throw new PaymentDeclinedException("Payment amount invalid.");
        }
        payment.setPaymentStatus("PAID");
        paymentRepository.save(payment);
    }
}
