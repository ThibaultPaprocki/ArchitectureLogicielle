package apaprocki.cc2.exposition.models;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class BillingInformationsDTO {

        @NotNull
        @NotBlank
        public int billingInformationsId;

        @NotNull
        @NotBlank
        public int cardNumber;

        @NotNull
        @NotBlank
        public LocalDateTime expirationDate;

        @NotNull
        @NotBlank
        public int secretPictogram;

        @NotNull
        @NotBlank
        public String ownerName;

}
