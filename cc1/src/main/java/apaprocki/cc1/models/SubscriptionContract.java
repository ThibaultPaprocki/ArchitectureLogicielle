package apaprocki.cc1.models;

import java.time.LocalDateTime;

public class SubscriptionContract {

    private LocalDateTime startSubscriptionDate;
    private LocalDateTime endSubscriptionDate;
    private int periodMonthDuration;
    private int price;
    private boolean subscribed;

    private SubscriptionContract(int periodDuration, int price) {
        this.periodMonthDuration = periodDuration;
        this.price = price;
        subscribed=false;
    }

    public static SubscriptionContract of(int periodMonthDuration, int price){
        return new SubscriptionContract(periodMonthDuration,price);
    }

    public LocalDateTime getStartSubscriptionDate() {
        return startSubscriptionDate;
    }

    public LocalDateTime getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public int getPrice() {
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
