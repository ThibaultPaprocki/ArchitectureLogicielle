package apaprocki.cc2.domain.models;

public class Member extends User {

    private final BillingInformations billingInformations;
    private MemberType memberType;

    private Member(Id id, String name, String firstname, String username, String password, BillingInformations billingInformations, MemberType memberType) {
        super(id, name, firstname, username, password);
        this.billingInformations = billingInformations;
        this.memberType = memberType;
    }

    public static Member of(User user, BillingInformations billingInformations, MemberType memberType) {
        return new Member(user.getId(), user.getName(), user.getFirstname(), user.getUsername(), user.getPassword(), billingInformations, memberType);
    }

    public BillingInformations getBillingInformations() {
        return billingInformations;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setType(MemberType type) {
        this.memberType = type;
    }

    @Override
    public String toString() {
        return "Member{" +
                "User=" + super.toString() +
                "billingInformations=" + billingInformations +
                ", memberType=" + memberType +
                '}';
    }
}
