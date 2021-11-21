package apaprocki.cc1.models;

import java.time.LocalDateTime;

public class BillingInformations {
    private String fullNameOwner;
    private LocalDateTime expirationDate;
    private int cardCode;
    private int secretCode;

    private BillingInformations(String fullNameOwner, LocalDateTime expirationDate, int cardCode, int secretCode) {
        this.fullNameOwner = fullNameOwner;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
        this.secretCode = secretCode;
    }

    public static BillingInformations of(String fullNameOwner, LocalDateTime expirationDate, int cardCode, int secretCode){
        return new BillingInformations(fullNameOwner,expirationDate,cardCode,secretCode);
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
