package apaprocki.cc1.models;

public class MemberStatus {
    private MemberType type;
    private SubscriptionContract subscriptionContract;

    private MemberStatus(MemberType type, SubscriptionContract subscriptionContract) {
        this.type = type;
        this.subscriptionContract = subscriptionContract;
    }

    public static MemberStatus of(MemberType type, SubscriptionContract subscriptionContract) {
        return new MemberStatus(type, subscriptionContract);
    }

    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }

    public SubscriptionContract getSubscriptionContract() {
        return subscriptionContract;
    }

    public void setSubscriptionContract(SubscriptionContract subscriptionContract) {
        this.subscriptionContract = subscriptionContract;
    }

    @Override
    public String toString() {
        return "MemberStatus{" +
                "type=" + type +
                ", subscriptionContract=" + subscriptionContract +
                '}';
    }
}
