package apaprocki.cc1.exceptions;

public class PaymentException extends RuntimeException {

    private PaymentException(String message) {
        super(message);
    }

    public static PaymentException error() {
        return new PaymentException(String.format("The payment failed"));
    }
}
