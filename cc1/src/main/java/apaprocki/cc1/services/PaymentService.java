package apaprocki.cc1.services;

import apaprocki.cc1.models.Payment;
import apaprocki.cc1.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentById(int paymentId) {
        return this.paymentRepository.getPaymentById(paymentId);
    }

    public boolean applyPayment(Payment payment) {
        return this.paymentRepository.executePayment(payment);
    }
}
