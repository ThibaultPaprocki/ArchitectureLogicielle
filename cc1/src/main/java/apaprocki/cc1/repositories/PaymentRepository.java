package apaprocki.cc1.repositories;

import apaprocki.cc1.models.Payment;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PaymentRepository {

    private final Map<Integer, Payment> data = new ConcurrentHashMap<>();

    public Payment getPaymentById(int id) {
        return data.get(id);
    }

    public boolean executePayment(Payment payment) {
        data.put(payment.getId(), payment);
        return true;
    }
}
