package apaprocki.cc2.domain.repositories;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.Payment;

import java.util.List;

public interface PaymentRepository {

    Id getNextId();

    Payment getPaymentById(Id id);

    List<Payment> getAll();

    Payment savePayment(Payment payment);

}