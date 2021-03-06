package apaprocki.cc2.infra.exceptions;

import apaprocki.cc2.domain.models.Id;

public class NotMemberException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private NotMemberException(String message) {
        super(message);
    }

    public static NotMemberException withId(Id id) {
        return new NotMemberException(String.format("The user ID %d have never sucribed to our membership", id.getId()));
    }
}