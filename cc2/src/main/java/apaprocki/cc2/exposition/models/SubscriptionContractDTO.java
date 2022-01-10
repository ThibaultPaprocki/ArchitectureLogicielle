package apaprocki.cc2.exposition.models;

import java.time.LocalDateTime;

public class SubscriptionContractDTO {

    public int subscriptionContractId;
    public int userId;
    public LocalDateTime startSubscriptionDate;
    public LocalDateTime endSubscriptionDate;
    public int periodMonthDuration;
    public double price;
    public boolean subscribed;

    public SubscriptionContractDTO(int id, int userId, double price, LocalDateTime startSubscriptionDate, LocalDateTime endSubscriptionDate) {
        this.subscriptionContractId = id;
        this.userId = userId;
        this.price = price;
        this.startSubscriptionDate = startSubscriptionDate;
        this.endSubscriptionDate = endSubscriptionDate;
    }

    public static SubscriptionContractDTO of(int id, int userId, double price,LocalDateTime startSubscriptionDate, LocalDateTime endSubscriptionDate) {
        return new SubscriptionContractDTO(id, userId, price, startSubscriptionDate, endSubscriptionDate);
    }

    @Override
    public String toString() {
        return "SubscriptionContractDTO{" +
                "subscriptionContractId=" + subscriptionContractId +
                ", userId=" + userId +
                ", startSubscriptionDate=" + startSubscriptionDate +
                ", endSubscriptionDate=" + endSubscriptionDate +
                ", periodMonthDuration=" + periodMonthDuration +
                ", price=" + price +
                ", subscribed=" + subscribed +
                '}';
    }
}
