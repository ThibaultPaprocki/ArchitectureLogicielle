package apaprocki.cc2.domain.services;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.SubscriptionContract;
import apaprocki.cc2.domain.repositories.SubscriptionContractRepository;
import apaprocki.cc2.infra.exceptions.NotMemberException;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

public class SubscriptionService {

    private SubscriptionContractRepository subscriptionContractRepository;

    public SubscriptionService(SubscriptionContractRepository subscriptionContractRepository) {
        this.subscriptionContractRepository = subscriptionContractRepository;
    }

    public Id getNextId() {
        return subscriptionContractRepository.getNextId();
    }

    public SubscriptionContract getContractById(Id id) {
        return subscriptionContractRepository.getSubscriptionContractById(id);
    }

    public List<SubscriptionContract> getAll() {
        return subscriptionContractRepository.getAll();
    }

    public SubscriptionContract addMembertoContract(SubscriptionContract contract) {
        return subscriptionContractRepository.saveSubscriptionContract(contract);
    }

    public boolean userHaveSuscribedToContract(Id userId) {
        return !getContractListByUserId(userId).isEmpty();
    }

    public List<SubscriptionContract> getContractListByUserId(Id userId) {
        return subscriptionContractRepository.getContractsByUserId(userId);
    }

    public SubscriptionContract getUserLastContract(Id userId) {
        List<SubscriptionContract> contracts = getContractListByUserId(userId);
        if(contracts.size() > 0) {
            SubscriptionContract contractResult = contracts.get(0);
            for (int i = 0; i < contracts.size(); i++) {
                SubscriptionContract contract = contracts.get(i);
                if(contract.getStartSubscriptionDate().isAfter(contractResult.getStartSubscriptionDate())) {
                    contractResult = contract;
                }
            }
            return contractResult;
        }else {
            throw NotMemberException.withId(userId);
        }
    }

    public boolean isCurrentlyMember(Id userId) {
        LocalDate today = LocalDate.now();
        SubscriptionContract contract = getUserLastContract(userId);
        return (contract.getStartSubscriptionDate().isBefore(ChronoLocalDateTime.from(today)) || contract.getStartSubscriptionDate().isEqual(ChronoLocalDateTime.from(today))) &&
                (contract.getEndSubscriptionDate().isAfter(ChronoLocalDateTime.from(today)) || contract.getEndSubscriptionDate().isEqual(ChronoLocalDateTime.from(today)));
    }

    public boolean isContractExist(Id id) {
        try {
            getContractById(id);
        } catch (Exception e) {
            return false;
        }
        return true;

    }
}
