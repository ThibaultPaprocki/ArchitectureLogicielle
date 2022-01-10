package apaprocki.cc2.domain.models;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Payment {

    private Id paymentId;
    private Id userId;
    private LocalDateTime transactionDate;
    private double paymentSum;

    public Payment(Id paymentId, Id userId, LocalDateTime transactionDate, double paymentSum) {
        this.paymentId = paymentId;
        this.userId = Objects.requireNonNull(userId,"UserId must be not null / A user must be related with that operation");
        this.transactionDate = Objects.requireNonNull(transactionDate,"TransactionDate must be not null / A date must be related with that operation");
        this.paymentSum = Objects.requireNonNull(paymentSum,"PaymentSum must be not null / A payment must be related with that operation");
    }

    public static Payment of(Id paymentId, Id userId, LocalDateTime transactionDate, double paymentSum){
        return new Payment(paymentId,userId,transactionDate,paymentSum);
    }

    public Id getPaymentId() {
        return paymentId;
    }

    public Id getUserId() {
        return userId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public double getPaymentSum() {
        return paymentSum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + paymentId +
                ", user=" + userId +
                ", transactionDate=" + transactionDate +
                ", paymentSum=" + paymentSum +
                '}';
    }
}
