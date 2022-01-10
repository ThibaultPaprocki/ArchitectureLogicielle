package apaprocki.cc2.infra.exceptions;

import apaprocki.cc2.domain.models.Id;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(Id id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getId()));
    }

    public static NoSuchEntityException withIdAndElem(Id id, String element) {
        return new NoSuchEntityException(String.format("No "+ element +" found with ID %d.", id.getId()));
    }
}