package apaprocki.cc2.infra.defaultRepositoryImpl;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.SubscriptionContract;
import apaprocki.cc2.domain.repositories.SubscriptionContractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemorySubscriptionContractRepository implements SubscriptionContractRepository {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<Id, SubscriptionContract> data = new ConcurrentHashMap<>();

    @Override
    public Id getNextId() {
        return Id.of(count.incrementAndGet());
    }

    @Override
    public SubscriptionContract getSubscriptionContractById(Id id){
        SubscriptionContract contract = data.get(id);
        if (contract == null) {
            //throw NoSuchEntityException.withIdAndElem(id,"contract");
        }
        return contract;
    }

    @Override
    public List<SubscriptionContract> getContractsByUserId(Id userId){
        List<SubscriptionContract> result = data.values().stream().filter(subcriptionContract -> { return subcriptionContract.getSubscriptionContractId().equals(userId); }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<SubscriptionContract> getAll() {
        List<SubscriptionContract> result = data.values().stream().collect(Collectors.toList());
        return result;
    }

    @Override
    public SubscriptionContract saveSubscriptionContract(SubscriptionContract contract) {
        data.put(contract.getSubscriptionContractId(), contract);
        return contract;
    }
}