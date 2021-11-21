package apaprocki.cc1.models;

import java.time.LocalDateTime;

public final class Payment {

    private int id;
    private User user;
    private LocalDateTime transactionDate;
    private double paymentSum;

    public Payment(int id, User user, LocalDateTime transactionDate, double paymentSum) {
        this.id = id;
        this.user = user;
        this.transactionDate = transactionDate;
        this.paymentSum = paymentSum;
    }

    public static Payment of(int id, User user, LocalDateTime transactionDate, double paymentSum){
        return new Payment(id,user,transactionDate,paymentSum);
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
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
                "id=" + id +
                ", user=" + user +
                ", transactionDate=" + transactionDate +
                ", paymentSum=" + paymentSum +
                '}';
    }
}
