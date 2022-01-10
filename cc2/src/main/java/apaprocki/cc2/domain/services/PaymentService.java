package apaprocki.cc2.domain.services;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.Payment;
import apaprocki.cc2.domain.repositories.PaymentRepository;
import java.util.List;

public class PaymentService {

    private  PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Id getNextId() {
        return paymentRepository.getNextId();
    }

    public Payment getPaymentById(Id id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<Payment> getAll() {
        return paymentRepository.getAll();
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.savePayment(payment);
    }

    public boolean applyPayment(Payment payment){
       if (payment.getPaymentSum()<0){
           return false;
       }
       return true;
    }

    public boolean paymentExist(Id id) {
        try {
            getPaymentById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}