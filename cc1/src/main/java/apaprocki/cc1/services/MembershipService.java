package apaprocki.cc1.services;

import apaprocki.cc1.exceptions.PaymentException;
import apaprocki.cc1.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    private PaymentService paymentService;
    private UserService userService;

    public MembershipService(PaymentService paymentService, UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }

    //old member
    public void reApplyToContract(Payment payment, SubscriptionContract newContract) throws PaymentException {
        Member oldMember = (Member) this.userService.getUserById(payment.getUser().getId());
        if (this.applyPayment(payment)) {
            oldMember.getMemberStatus().setSubscriptionContract(newContract);
            oldMember.getMemberStatus().getSubscriptionContract().subsribeContract();
        } else {
            throw PaymentException.error();
        }
    }

    //new member
    public void applyToContract(Payment payment, BillingInformations billingInformations, SubscriptionContract contract) {
        if (this.applyPayment(payment)) {
            Member newMember = Member.of(
                    this.userService.getUserById(payment.getUser().getId()),
                    billingInformations,
                    MemberStatus.of(
                            MemberType.Trademan,
                            contract
                    )
            );
            newMember.getMemberStatus().getSubscriptionContract().subsribeContract();
            this.userService.addUser(newMember);
        } else {
            throw PaymentException.error();
        }
    }

    public boolean applyPayment(Payment payment) {
        return this.paymentService.applyPayment(payment);
    }
}
