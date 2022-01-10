package apaprocki.cc2.domain.repositories;

import java.util.List;

import apaprocki.cc2.domain.models.BillingInformations;
import apaprocki.cc2.domain.models.Id;

public interface BillingInformationsRepository {

    Id getNextId();

    BillingInformations getBillingInformationById(Id id);

    List<BillingInformations> getAll();

    BillingInformations saveBillingInformation(BillingInformations billingInformation);

    BillingInformations getBillingInformationByUserId(Id userId);
}