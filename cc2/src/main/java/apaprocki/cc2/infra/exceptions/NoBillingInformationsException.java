package apaprocki.cc2.infra.exceptions;

import apaprocki.cc2.domain.models.Id;

public class NoBillingInformationsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private NoBillingInformationsException(String message) {
        super(message);
    }

    public static NoBillingInformationsException withId(Id id) {
        return new NoBillingInformationsException(String.format("No billing information found for user with ID %d.", id.getId()));
    }
}
