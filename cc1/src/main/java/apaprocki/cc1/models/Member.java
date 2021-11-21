package apaprocki.cc1.models;

public class Member extends User {

    private final BillingInformations billingInformations;
    private final MemberStatus memberStatus;

    private Member(int id, String name, String firstname, String username, String password, BillingInformations billingInformations, MemberStatus memberStatus) {
        super(id, name, firstname, username, password);
        this.billingInformations = billingInformations;
        this.memberStatus = memberStatus;
    }

    public static Member of(User user, BillingInformations billingInformations, MemberStatus memberStatus) {
        return new Member(user.getId(), user.getName(), user.getFirstname(), user.getUsername(), user.getPassword(), billingInformations, memberStatus);
    }

    public BillingInformations getBillingInformations() {
        return billingInformations;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "User=" + super.toString() +
                "billingInformations=" + billingInformations +
                ", memberStatus=" + memberStatus +
                '}';
    }
}
