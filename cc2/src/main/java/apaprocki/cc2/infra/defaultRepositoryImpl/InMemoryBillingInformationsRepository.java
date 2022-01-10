package apaprocki.cc2.infra.defaultRepositoryImpl;

import apaprocki.cc2.domain.models.BillingInformations;
import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.repositories.BillingInformationsRepository;
import apaprocki.cc2.infra.exceptions.NoBillingInformationsException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryBillingInformationsRepository implements BillingInformationsRepository{

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<Id, BillingInformations> data = new ConcurrentHashMap<>();

    @Override
    public Id getNextId() {
        return Id.of(count.incrementAndGet());
    }

    @Override
    public BillingInformations getBillingInformationById(Id id) {
        BillingInformations billingInformation = data.get(id);
        if (billingInformation == null) {
            //throw NoSuchEntityException.withIdAndElem(id,"Billing informations");
        }
        return billingInformation;
    }

    @Override
    public List<BillingInformations> getAll() {
        List<BillingInformations> result = data.values().stream().collect(Collectors.toList());
        return  result;
    }

    @Override
    public BillingInformations saveBillingInformation(BillingInformations billingInformations) {
        data.put(billingInformations.getBillingId(), billingInformations);
        return billingInformations;
    }

    @Override
    public BillingInformations getBillingInformationByUserId(Id userId) {
        for (Map.Entry<Id, BillingInformations> entry : data.entrySet()) {
            if(entry.getValue().getUserId().equals(userId)) {
                return entry.getValue();
            }
        }
       throw NoBillingInformationsException.withId(userId);
    }
}