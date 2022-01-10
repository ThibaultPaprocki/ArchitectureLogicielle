package apaprocki.cc2.domain.repositories;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.SubscriptionContract;

import java.util.List;

public interface SubscriptionContractRepository {

    Id getNextId();

    SubscriptionContract getSubscriptionContractById(Id id);

    List<SubscriptionContract> getAll();

    SubscriptionContract saveSubscriptionContract(SubscriptionContract contract);

    List<SubscriptionContract> getContractsByUserId(Id userId);

}