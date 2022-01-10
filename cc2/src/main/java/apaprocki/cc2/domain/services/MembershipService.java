package apaprocki.cc2.domain.services;

import apaprocki.cc2.domain.models.*;
import apaprocki.cc2.domain.repositories.SubscriptionContractRepository;
import apaprocki.cc2.exposition.models.BillingInformationsDTO;
import apaprocki.cc2.exposition.models.SubscriptionContractDTO;
import apaprocki.cc2.infra.exceptions.PaymentException;

public class MembershipService {

    private PaymentService paymentService;
    private UserService userService;

    private SubscriptionContractRepository subscriptionContractRepository;

    public MembershipService(PaymentService paymentService, UserService userService, SubscriptionContractRepository subscriptionContractRepository) {
        this.paymentService = paymentService;
        this.userService = userService;
        this.subscriptionContractRepository = subscriptionContractRepository;
    }

    //old member
    public void reApplyToContract(Payment payment, SubscriptionContractDTO newContract) throws PaymentException {
        Member oldMember = (Member) this.userService.getUserById(payment.getUserId());
        if (this.applyPayment(payment)) {
            SubscriptionContract subscriptionContract = SubscriptionContract.of(Id.of(newContract.subscriptionContractId),Id.of(newContract.userId),newContract.periodMonthDuration, newContract.price);
            subscriptionContract.subsribeContract();
            this.subscriptionContractRepository.saveSubscriptionContract(subscriptionContract);
        } else {
            throw PaymentException.error();
        }
    }

    //new member
    public void applyToContract(Payment payment, BillingInformationsDTO billingInformations, SubscriptionContractDTO contract) {
        if (this.applyPayment(payment)) {

            Member newMember = Member.of(
                    this.userService.getUserById(payment.getUserId()),
                    BillingInformations.of(Id.of(billingInformations.billingInformationsId),payment.getUserId(), billingInformations.ownerName, billingInformations.expirationDate,billingInformations.cardNumber, billingInformations.secretPictogram),
                    MemberType.Trademan
            );

            SubscriptionContract subscriptionContract = SubscriptionContract.of(Id.of(contract.subscriptionContractId),Id.of(contract.userId),contract.periodMonthDuration, contract.price);
            subscriptionContract.subsribeContract();
            this.subscriptionContractRepository.saveSubscriptionContract(subscriptionContract);
            this.userService.addUser(newMember);
        } else {
            throw PaymentException.error();
        }
    }

    public boolean applyPayment(Payment payment) {
        return this.paymentService.applyPayment(payment);
    }

}
