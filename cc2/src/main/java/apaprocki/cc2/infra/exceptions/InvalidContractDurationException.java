package apaprocki.cc2.infra.exceptions;

public class InvalidContractDurationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private InvalidContractDurationException(String message) {
        super(message);
    }

    public static InvalidContractDurationException withDay(int day) {
        return new InvalidContractDurationException(String.format("contract duration cannot be 0 day or less. found : %d days.", day));
    }
}
