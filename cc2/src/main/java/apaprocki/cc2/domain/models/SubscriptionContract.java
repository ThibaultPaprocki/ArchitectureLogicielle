package apaprocki.cc2.domain.models;

import java.time.LocalDateTime;

public class SubscriptionContract {

    private Id subscriptionContractId;
    private Id userId;
    private LocalDateTime startSubscriptionDate;
    private LocalDateTime endSubscriptionDate;
    private int periodMonthDuration;
    private double price;
    private boolean subscribed;

    private SubscriptionContract(Id subscriptionContractId, Id userId, int periodDuration, double price) {
        this.subscriptionContractId = subscriptionContractId;
        this.userId = userId;
        this.periodMonthDuration = periodDuration;
        this.price = price;
        subscribed=false;
    }

    public static SubscriptionContract of(Id subscriptionContractId, Id userId, int periodMonthDuration, double price){
        return new SubscriptionContract(subscriptionContractId,userId,periodMonthDuration,price);
    }

    public Id getSubscriptionContractId() {
        return subscriptionContractId;
    }

    public Id getUserId() {
        return userId;
    }

    public LocalDateTime getStartSubscriptionDate() {
        return startSubscriptionDate;
    }

    public LocalDateTime getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public double getPrice() {
        return price;
    }

    public int getPeriodMonthDuration(){
        return periodMonthDuration;
    }

    public void subsribeContract(){
        subscribed=true;
        startSubscriptionDate= LocalDateTime.now();
        endSubscriptionDate=LocalDateTime.now().plusMonths(periodMonthDuration);
    }

    public boolean isSubscribed(){
        return subscribed;
    }
}
