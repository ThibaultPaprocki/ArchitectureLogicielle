package apaprocki.cc2.domain.models;

import java.time.LocalDateTime;

public class BillingInformations {

    private Id billingId;
    private Id userId;
    private String fullNameOwner;
    private LocalDateTime expirationDate;
    private int cardCode;
    private int secretCode;

    private BillingInformations(Id billingId, Id userId, String fullNameOwner, LocalDateTime expirationDate, int cardCode, int secretCode) {
        this.billingId = billingId;
        this.userId = userId;
        this.fullNameOwner = fullNameOwner;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
        this.secretCode = secretCode;
    }

    public static BillingInformations of(Id billingId, Id userId, String fullNameOwner, LocalDateTime expirationDate, int cardCode, int secretCode){
        return new BillingInformations(billingId, userId, fullNameOwner,expirationDate,cardCode,secretCode);
    }

    public Id getBillingId() {
        return billingId;
    }

    public Id getUserId() {
        return userId;
    }

    public String getFullNameOwner() {
        return fullNameOwner;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public int getCardCode() {
        return cardCode;
    }

    public int getSecretCode() {
        return secretCode;
    }

    @Override
    public String toString() {
        return "BillingInformations{" +
                "fullNameOwner='" + fullNameOwner + '\'' +
                ", expirationDate=" + expirationDate +
                ", cardCode=" + cardCode +
                ", secretCode=" + secretCode +
                '}';
    }
}
