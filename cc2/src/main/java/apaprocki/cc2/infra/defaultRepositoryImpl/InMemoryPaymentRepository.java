package apaprocki.cc2.infra.defaultRepositoryImpl;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.Payment;
import apaprocki.cc2.domain.repositories.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryPaymentRepository implements PaymentRepository {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<Id, Payment> data = new ConcurrentHashMap<>();

    @Override
    public Id getNextId() {
        return Id.of(count.incrementAndGet());
    }

    @Override
    public Payment getPaymentById(Id id) {
        Payment payment = data.get(id);
        if (payment == null) {
            //throw NoSuchEntityException.withIdAndElem(id,"Payment");
        }
        return payment;
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> result = data.values().stream().collect(Collectors.toList());
        return result;
    }

    @Override
    public Payment savePayment(Payment payment) {
        data.put(payment.getPaymentId(), payment);
        return payment;
    }
}